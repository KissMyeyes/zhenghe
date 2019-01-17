package com.example.wwmd.service;

import com.example.wwmd.dao.mapper.UserMapper;
import com.example.wwmd.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by CaiBaoHong at 2018/4/18 16:08<br>
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 模拟查询返回用户信息
     *
     * @param uname
     * @return
     */
    public User findUserByName(String uname) {
//        User user = new User();
//        user.setId(1L);
//        user.setUserName(uname);
//        user.setRealName(uname + "NICK");
//        user.setPassword("J/ms7qTJtqmysekuY8/v1TAS+VKqXdH5sB7ulXZOWho=");//密码明文是123456
////        user.setSalt("wxKYXuTPST5SG0jMQzVPsg==");//加密密码的盐值
//        user.setId(new Random().nextLong());//随机分配一个id
//        user.setLocked("1");

        return userMapper.selectByPrimaryKey(6L);
    }


    public List<User> getAll(User User) {
        if (User.getPage() != null && User.getRows() != null) {
            PageHelper.startPage(User.getPage(), User.getRows());
        }
        return userMapper.selectAll();
    }

    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void save(User country) {
        if (country.getId() != null) {
            userMapper.updateByPrimaryKey(country);
        } else {
            userMapper.insert(country);
        }
    }

//    @Transactional
//    public void updateLoginTime(String userName) {
//        Example example = new Example(User.class);
//        example.createCriteria().andCondition("lower(username)=", userName.toLowerCase());
//        User user = new User();
//        user.setLastLoginTime(new Date());
//        this.userMapper.updateByExampleSelective(user, example);
//    }
}
