package com.study.demo.mongo.test;

import com.alibaba.fastjson.JSON;
import com.study.demo.mongo.demo.dao.HotelDao;
import com.study.demo.mongo.demo.entity.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class HotelDaoTest {


    @Autowired
    HotelDao hotelDao;

    @Autowired
    MongoTemplate mongoTemplate;


    @Test
    public void testFind() {

//		System.out.println("--------------");
//		hotelDao.getByName("麓谷大酒店");

//		Query query = new Query();
//		List<Hotel> result = mongoTemplate.find(query, Hotel.class);


        Hotel hotel = new Hotel();
        hotel.setHotelName("麓谷酒店");
        hotel.setHotelAddress("湖南长沙高新区麓谷企业广场");
        mongoTemplate.insert(hotel);

//		System.out.println(JSON.toJSONString(result, true));

//		List<Hotel> result = hotelDao.getById("5a3a53d9442db6c6c0f68e3d");
//		System.out.println(JSON.toJSONString(result, true));

        List<Hotel> result = hotelDao.getAll();
        System.out.println(JSON.toJSONString(result, true));

    }

}
