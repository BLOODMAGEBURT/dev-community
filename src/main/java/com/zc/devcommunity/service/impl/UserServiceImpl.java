package com.zc.devcommunity.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.devcommunity.dao.UserMapper;
import com.zc.devcommunity.entity.*;
import com.zc.devcommunity.pojo.Login;
import com.zc.devcommunity.pojo.User;
import com.zc.devcommunity.service.UserService;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

import static com.zc.devcommunity.entity.CacheKey.CAPTCHA_KEY;

/****
 * @Author:xujianbo
 * @Description:User业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * User条件+分页查询
     *
     * @param user 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<User> findPage(User user, int page, int size) {
        //分页
        PageHelper.startPage(page, size);
        //搜索条件构建
        Example example = createExample(user);
        //执行搜索
        return new PageInfo<User>(userMapper.selectByExample(example));
    }

    /**
     * User分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<User> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page, size);
        //分页查询
        return new PageInfo<User>(userMapper.selectAll());
    }

    /**
     * User条件查询
     *
     * @param user
     * @return
     */
    @Override
    public List<User> findList(User user) {
        //构建查询条件
        Example example = createExample(user);
        //根据构建的条件查询数据
        return userMapper.selectByExample(example);
    }


    /**
     * User构建查询对象
     *
     * @param user
     * @return
     */
    public Example createExample(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (user != null) {
            // 主键id
            if (!StringUtils.isEmpty(user.getId())) {
                criteria.andEqualTo("id", user.getId());
            }
            // 登录名
            if (!StringUtils.isEmpty(user.getUsername())) {
                criteria.andLike("username", "%" + user.getUsername() + "%");
            }
            // 登陆密码
            if (!StringUtils.isEmpty(user.getPassword())) {
                criteria.andEqualTo("password", user.getPassword());
            }
            // 姓名
            if (!StringUtils.isEmpty(user.getName())) {
                criteria.andLike("name", "%" + user.getName() + "%");
            }
            // 手机号
            if (!StringUtils.isEmpty(user.getTelphone())) {
                criteria.andEqualTo("telphone", user.getTelphone());
            }
            // 邮箱
            if (!StringUtils.isEmpty(user.getEmail())) {
                criteria.andEqualTo("email", user.getEmail());
            }
            // 用户头像
            if (!StringUtils.isEmpty(user.getUserPic())) {
                criteria.andEqualTo("userPic", user.getUserPic());
            }
            // 创建时间
            if (!StringUtils.isEmpty(user.getCreateTime())) {
                criteria.andEqualTo("createTime", user.getCreateTime());
            }
            // 修改时间
            if (!StringUtils.isEmpty(user.getEditTime())) {
                criteria.andEqualTo("editTime", user.getEditTime());
            }
            // 关注数量
            if (!StringUtils.isEmpty(user.getFollowedCount())) {
                criteria.andEqualTo("followedCount", user.getFollowedCount());
            }
            // 粉丝数量
            if (!StringUtils.isEmpty(user.getFollowerCount())) {
                criteria.andEqualTo("followerCount", user.getFollowerCount());
            }
            // 博文数量
            if (!StringUtils.isEmpty(user.getPostCount())) {
                criteria.andEqualTo("postCount", user.getPostCount());
            }
            // 是否专家
            if (!StringUtils.isEmpty(user.getIsExpert())) {
                criteria.andEqualTo("isExpert", user.getIsExpert());
            }
            // 状态(1正常，2停用，3删除)
            if (!StringUtils.isEmpty(user.getStatus())) {
                criteria.andEqualTo("status", user.getStatus());
            }
        }
        return example;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改User
     *
     * @param user
     */
    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 增加User
     *
     * @param user
     */
    @Override
    public void add(User user) {
        // 设置id
        user.setId(idWorker.nextId());
        // 设置时间
        user.setCreateTime(new Date());
        user.setEditTime(new Date());
        // 密码加密
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userMapper.insert(user);
    }

    /**
     * 根据ID查询User
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /*
     * 根据用户名查询用户
     * */
    @Override
    public User findByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andEqualTo("username", username);
        }

        User user = userMapper.selectOneByExample(example);

        return user;
    }

    /**
     * 查询User全部数据
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public Map<String, String> checkLogin(Login login) {

        HashMap<String, String> map = new HashMap<>();
        String captcha = (String) redisUtils.get(CAPTCHA_KEY.concat(login.getCaptchaKey()));

        // 转为大写
        if (!login.getCaptcha().toUpperCase().equals(captcha)) {
            map.put("code", "20003");
            map.put("msg", "验证码错误");
            return map;
        }

        if (!StringUtils.isEmpty(login.getUserName())) {

            User byUsername = findByUsername(login.getUserName());

            if (byUsername != null && BCrypt.checkpw(login.getPassword(), byUsername.getPassword())) {

                // 创建令牌
                HashMap<String, Object> tokenInfo = new HashMap<>();
                tokenInfo.put("role", "User");
                tokenInfo.put("username", login.getUserName());

                String token = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(tokenInfo), null);

                map.put("code", "20000");
                map.put("msg", "登陆成功");
                map.put("token", token);
                return map;
            }
        }

        map.put("code", "20002");
        map.put("msg", "账号或密码错误");
        return map;
    }
}
