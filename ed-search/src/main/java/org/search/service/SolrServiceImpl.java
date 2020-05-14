package org.search.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.search.entity.CourseSolr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SolrServiceImpl implements SolrService{

    @Autowired
    SolrClient solrClient;

    //多条件查询课程信息
    @Override
    public List<CourseSolr> findByCondition(Integer pageNo, String courseName){
        SolrQuery solrQuery = null;

        //q(条件判断)
        if(courseName == null){
            solrQuery=new SolrQuery("*:*");//查询所有
        } else {
            //实例化
            solrQuery = new SolrQuery();
            //添加条件
            solrQuery.set("q" , "course_name:"+courseName);
        }

        //排序(降序)
        solrQuery.addSort("course_sort",SolrQuery.ORDER.desc);
        //当前页判断
        int pageSize = 5;//页大小
        int count = (pageNo - 1)*pageSize;//当前页
        solrQuery.setStart(count);
        solrQuery.setRows(pageSize);

        //高亮配置
        solrQuery.setHighlight(true);//启动高亮
        solrQuery.addHighlightField(courseName);//设置域名称
        solrQuery.setHighlightSimplePre("<font color='blue'>");
        solrQuery.setHighlightSimplePost("</font>");

        QueryResponse query = null;
        try {
            query = solrClient.query(solrQuery);
        } catch (Exception e){
            e.printStackTrace();
        }

        long numFound = query.getResults().getNumFound();
        System.out.println("总记录数："+numFound);

        List<CourseSolr> solrList = query.getBeans(CourseSolr.class);

        return solrList;
    }


//简单查询
//    public void select() throws Exception {
//        SolrQuery solrQuery=new SolrQuery("*:*");//查询所有
//        QueryResponse query = solrClient.query(solrQuery);
//
//        long numFound = query.getResults().getNumFound();
//        System.out.println("总记录数："+numFound);
//
//        List<CourseSolr> beans = query.getBeans(CourseSolr.class);
//        for(CourseSolr cou:beans){
//            System.out.println(cou.getCourseName() + cou.getIsFree());
//        }
//    }
//创建多条件组合字符串
//StringBuilder builder = new StringBuilder();
//        builder.append("course_name:"+courseName);

//        添加条件
//        solrQuery.setQuery(builder.toString());
//        System.out.println(builder.toString());
}
