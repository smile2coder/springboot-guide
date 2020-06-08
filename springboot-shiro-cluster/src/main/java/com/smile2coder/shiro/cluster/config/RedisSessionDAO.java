package com.smile2coder.shiro.cluster.config;


import com.smile2coder.shiro.cluster.redis.StringRedis;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

/**
 * @author ZxT
 * @date 2020-06-07
 * @desc
 */
@Component
public class RedisSessionDAO extends AbstractSessionDAO {

    private static final String SHIRO_REDIS_PREFIX = "shiro_redis_prefix_";

    @Autowired
    private StringRedis stringRedis;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        if (sessionId == null) {
            throw new NullPointerException("id argument cannot be null.");
        }
        this.stringRedis.set(getRealKey(sessionId), session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        Object session = this.stringRedis.get(getRealKey(sessionId));
        if (Objects.isNull(session)) {
            return null;
        }
        return (Session) session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        Serializable sessionId = session.getId();
        if (sessionId == null) {
            throw new NullPointerException("id argument cannot be null.");
        }
        this.stringRedis.set(getRealKey(sessionId), session);
    }

    @Override
    public void delete(Session session) {
        if (session == null) {
            throw new NullPointerException("session argument cannot be null.");
        }
        Serializable id = session.getId();
        if (id != null) {
            this.stringRedis.delete(getRealKey(id));
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Serializable> sessionIds = this.stringRedis.scan(SHIRO_REDIS_PREFIX + "*");
        List<Session> result = new ArrayList<>();
        for (Serializable sessionId : sessionIds) {
            Object session = this.stringRedis.get(getRealKey(sessionId));
            result.add((Session) session);
        }
        return result;
    }

    private Serializable getRealKey(Serializable key) {
        return SHIRO_REDIS_PREFIX + key;
    }
}
