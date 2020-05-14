package org.search.service;

import org.apache.solr.client.solrj.SolrServerException;
import org.search.entity.CourseSolr;

import java.io.IOException;
import java.util.List;

public interface SolrService{

    //查询课程信息(多条件查询)
    List<CourseSolr> findByCondition(Integer pageNo , String courseName);

}
