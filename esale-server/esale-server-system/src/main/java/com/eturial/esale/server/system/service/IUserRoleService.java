package com.eturial.esale.server.system.service;


public interface IUserRoleService {
    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}
