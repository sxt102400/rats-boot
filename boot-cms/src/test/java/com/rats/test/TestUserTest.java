package com.rats.test;

import com.rats.SpringBootCMSApplication;
import com.rats.framework.common.data.Example;
import com.rats.framework.common.data.MatchMode;
import com.rats.framework.common.page.Page;
import com.rats.framework.common.page.PageHelper;
import com.rats.framework.common.page.Pageable;
import com.rats.rbac.entity.TestUser;
import com.rats.rbac.service.TestUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootCMSApplication.class)
@Transactional
public class TestUserTest {

    private Logger logger = LoggerFactory.getLogger(TestUserTest.class);

    @Autowired
    private TestUserService testUserService;

    @Test
    public void countTest() {
        logger.info(" =================== count() ========================");
        Assert.assertTrue(testUserService.count() != 0);
        logger.info(" =================== count(example) ========================");
        Example example = new Example();
        example.<TestUser>createCriteria().andLike(TestUser::getUsername, MatchMode.ANY.contact("hanb"));
        Assert.assertTrue(testUserService.count(example) != 0);
    }

    @Test
    public void findAllTest() {
        Pageable pageable = PageHelper.getPage(1, 10);
        Example example = new Example();
        example.<TestUser>createCriteria().andLike(TestUser::getUsername, "hanb");

        logger.info(" =================== findAll(); ========================");
        List<TestUser> data1 = testUserService.findAll();
        Assert.assertNotNull(data1);
        logger.info("page item:{}", data1);

        logger.info(" =================== findAll(example); ========================");
        List<TestUser> data2 = testUserService.findAll(example);
        Assert.assertNotNull(data2);
        logger.info("page item:{}", data2);

        logger.info(" =================== findAll(pageable); ========================");
        Page page1 = testUserService.findAll(pageable);
        Assert.assertNotNull(page1);
        logger.info("page item:{}", page1);

        logger.info(" =================== findAll(example, pageable); ========================");
        Page page2 = testUserService.findAll(example, pageable);
        Assert.assertNotNull(page2);
        page2.getData().stream().forEach(item -> logger.info("page item:{}", item));
    }

    @Test
    public void findAllByIdsTest() {
        logger.info(" =================== findAllByIdsTest ========================");

        TestUser.Key key = new TestUser.Key();
        key.setId(1);
        key.setSid(1);

        List<TestUser.Key > ids = Stream.of(key).collect(Collectors.toList());
        List<TestUser> data = testUserService.findAllByIds(ids);
        Assert.assertNotNull(data);
        data.stream().forEach(item -> logger.info("page item:{}", item));
    }

    @Test
    public void findOneByIdTest() {
        logger.info(" =================== findAllByIdsTest ========================");
        TestUser.Key key = new TestUser.Key();
        key.setId(1);
        key.setSid(1);
        TestUser data = testUserService.findOneById(key).orElseThrow(()->new RuntimeException("Invalid Object."));
        Assert.assertNotNull(data);
        logger.info("data:{}", data);
    }

    @Test
    public void findOneTest() {
        logger.info(" =================== findOne(example) ========================");
        Example example = new Example();
        example.<TestUser>createCriteria().andLike(TestUser::getUsername, "%hanb%");

        TestUser data = testUserService.findOne(example).orElseThrow(()->new RuntimeException("invalid value"));
        Assert.assertNotNull(data);
        logger.info("data:{}", data);
    }

    @Test
    public void existsTest() {
        logger.info(" =================== existsById(example) ========================");
        TestUser.Key key = new TestUser.Key();
        key.setId(1);
        key.setSid(1);

        Assert.assertTrue(testUserService.existsById(key));

        logger.info(" =================== exists(example) ========================");
        Example example = new Example();
        example.<TestUser>createCriteria().andLike(TestUser::getUsername, "%hanb%");
        Assert.assertTrue(testUserService.exists(example));
    }

    @Test
    //@Transactional(propagation=Propagation.NOT_SUPPORTED)
    public void saveTest() {
        logger.info(" =================== saveTest ========================");
        TestUser entity = new TestUser();
        entity.setId(5);
        entity.setSid(5);
        entity.setUsername("hanbing");
        entity.setPhone("");
        entity.setMobile("13813899495");
        entity.setCreateDate(new Date());
        testUserService.save(entity);
    }

    @Test
    public void updateTest() {
        logger.info(" =================== saveTest ========================");
        TestUser entity = new TestUser();
        entity.setId(12345);
        entity.setUsername("hanbing");
        entity.setPhone("");
        entity.setMobile("13813899495");
        entity.setCreateDate(new Date());
        testUserService.update(entity);
    }

    @Test
    public void saveOrUpdateTest() {
        logger.info(" =================== saveOrUpdate(entity) ========================");
        TestUser entity = new TestUser();
        entity.setId(1);
        entity.setSid(1);
        entity.setUsername("hanbing");
        entity.setPhone("");
        entity.setMobile("13813899495");
        entity.setCreateDate(new Date());
        testUserService.saveOrUpdate(entity);
    }

    @Test
    public void deleteTest() {
        logger.info(" =================== deleteAll() ========================");
        testUserService.deleteAll();

        logger.info(" =================== delete(example)========================");
        Example example = new Example();
        example.<TestUser>createCriteria().andIn(TestUser::getId, Stream.of(1, 2, 3, 4).collect(Collectors.toList()));
        testUserService.delete(example);

        logger.info(" =================== deleteById(id)========================");
        TestUser.Key key = new TestUser.Key();
        key.setId(1);
        key.setSid(1);
        testUserService.deleteById(key);

        logger.info(" =================== deleteAll(TestUser)========================");
        TestUser d1 = new TestUser();
        d1.setUsername("001");
        TestUser d2 = new TestUser();
        d2.setUsername("002");
        TestUser d3 = new TestUser();
        d3.setUsername("002");
        testUserService.deleteAll(Stream.of(d1, d2, d3).collect(Collectors.toList()));
    }

}