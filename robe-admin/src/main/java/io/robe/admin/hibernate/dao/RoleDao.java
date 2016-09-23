package io.robe.admin.hibernate.dao;


import io.robe.admin.hibernate.entity.Role;
import io.robe.auth.data.entry.RoleEntry;
import io.robe.auth.data.store.RoleStore;
import io.robe.hibernate.dao.BaseDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import java.util.Optional;

public class RoleDao extends BaseDao<Role> implements RoleStore {

    @Inject
    public RoleDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public Optional<? extends RoleEntry> findByRoleId(String oid) {
        return Optional.ofNullable(findById(oid));
    }

    public Optional<Role> findByName(String code) {
        Criteria criteria = currentSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("code", code));
        return Optional.ofNullable(uniqueResult(criteria));
    }

    public Optional<Role> findByNameAndNotEqualMe(String code, String oid) {
        Criteria criteria = currentSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("code", code));
        criteria.add(Restrictions.not(Restrictions.eq("oid", oid)));

        return Optional.ofNullable(uniqueResult(criteria));
    }
}