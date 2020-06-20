package com.study.demo.mongo.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import com.study.demo.mongo.demo.entity.Hotel;
import com.study.demo.mongoDB.mongo.BaseDaoSupport;
import com.study.demo.mongoDB.mongo.QueryRule;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class HotelDao extends BaseDaoSupport<Hotel, Long> {

    public List<Hotel> getById(String id) {

        QueryRule queryRule = QueryRule.getInstance();
        queryRule.andEqual(this.getPKColumn(), id);

        return super.find(queryRule);

    }

    @Override
    public List<Hotel> getAll() {

        QueryRule queryRule = QueryRule.getInstance();
        queryRule.addAscOrder("price");

        return super.find(queryRule);

    }

    @Override
    @Resource(name = "mongoTemplate")
    protected void setTemplate(MongoTemplate template) {
        super.setTemplate(template);
    }


    @Override
    protected String getPKColumn() {
        return "_id";
    }

}
