package org.sang.service;

import org.sang.bean.MongoItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MongoDaoService {
    private Logger logger = LoggerFactory.getLogger(MongoDaoService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    public boolean insert(String name) {
        MongoItem item = new MongoItem();
        item.setName(name);
        item.setDate(new Date());
        try {
            mongoTemplate.insert(item,"noob");
            logger.info("a record is inserted successfully!");
        } catch (Exception e) {
            logger.error("info:{}, msg:{}", "mongodb is failure", e.getMessage());
            return false;
        }
        return true;
    }

    public MongoItem find(String name) {
        //校验
        //构造查询条件
        Criteria criteria = Criteria.where("name").is(name);
        List<MongoItem> results;
        try {
            results = mongoTemplate.find(Query.query(criteria), MongoItem.class,"noob");
            logger.info("few records are showing! data: {}", results.toString());
        } catch (Exception e) {
            logger.error("info:{}, msg:{}", "monttgodb is failure", e.getMessage());
            return null;
        }
        return results.stream().findFirst().orElse(null);
    }
}
