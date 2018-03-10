/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.data;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.common.api.snow.tables.model.LinkValue;
import com.disney.cast.platform.common.api.snow.tables.model.SysUserTableRecord;
import com.disney.cast.platform.common.data.AbstractDataManager;
import com.disney.cast.platform.estp.api.snow.tables.UIUserTableApi;
import com.disney.cast.platform.estp.api.snow.tables.model.PayrollTableRecord;
import com.disney.cast.platform.estp.api.snow.tables.model.UIUserTableRecord;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author luis.martinez
 */
public class UIUserDataManager extends AbstractDataManager<UIUserTableApi, UIUserTableRecord> {
    private boolean createActive;
    private SysUserTableRecord sysUser;
    private SysUserTableRecord sysLeader;
    private PayrollTableRecord payroll;
    private String uRole;

    protected UIUserDataManager() throws IOException {
        super(XLS.VACATION_PLANNER_REWARDS.get(), ExcelSheets.ALERT);
    }

    @Override
    protected UIUserTableRecord postProcess(UIUserTableRecord instance) throws Exception {
        return instance;
    }

    @Override
    protected TypeReference<?> getTypeReference() {
        return new TypeReference<Result<UIUserTableRecord>>() {
        };
    }

    @Override
    protected UIUserTableRecord processRow(Row currentRow) throws Exception {
        UIUserTableRecord record = new UIUserTableRecord();
        record.setUActive(String.valueOf(this.createActive));
        record.setUUser(new LinkValue(sysUser.getSysId()));
        record.setULeader(new LinkValue(this.sysLeader.getSysId()));
        record.setUPayroll(new LinkValue(payroll.getSysId()));
        if (uRole != null) {
            record.setURole(uRole);
        }
        return record;
    }

    public Set<UIUserTableRecord> addActive(SysUserTableRecord user, SysUserTableRecord leader,
            PayrollTableRecord payroll) throws Exception {
        return addActive(user, leader, payroll, null);
    }

    public Set<UIUserTableRecord> addActive(SysUserTableRecord user, SysUserTableRecord leader,
            PayrollTableRecord payroll, String uRole) throws Exception {
        createActive = true;
        this.sysUser = user;
        this.sysLeader = leader;
        this.payroll = payroll;
        this.uRole = uRole;
        return add(1, (currentRow) -> {
            Cell cell = currentRow.getCell(0);
            return cell != null;
        });
    }

    public Set<UIUserTableRecord> addInactive(SysUserTableRecord user, SysUserTableRecord leader,
            PayrollTableRecord payroll) throws Exception {
        createActive = false;
        this.sysUser = user;
        this.sysLeader = leader;
        this.payroll = payroll;
        return add(1, (currentRow) -> {
            Cell cell = currentRow.getCell(0);
            return cell != null;
        });
    }

    public Set<UIUserTableRecord> getAllUiUsers()
            throws JsonParseException, JsonMappingException, IOException, Exception {
        Set<UIUserTableRecord> uiUsers = getApi()
                .get(
                        getClient())
                .getBodyObject(new TypeReference<Result<Set<UIUserTableRecord>>>() {
                })
                .getResult();

        return uiUsers;
    }

    @Override
    public void deleteAll() throws Exception {
        Set<String> doNotDeleteUsers = new HashSet<>();
        doNotDeleteUsers.addAll(
                Arrays.asList(
                        "316320cedb03b6007e85d2c75e961919", "b1932c8edb03b6007e85d2c75e96196c",
                        "7ee37cdfdbfffa407e85d2c75e96194e"));
        List<UIUserTableRecord> uiUsers = getApi()
                .get(
                        getClient())
                .getBodyObject(new TypeReference<Result<List<UIUserTableRecord>>>() {
                })
                .getResult();
        for (UIUserTableRecord uiUser : uiUsers) {
            if (!doNotDeleteUsers.contains(uiUser.getSysId())) {
                getApi().delete(
                        getClient(),
                        uiUser.getSysId());
            }
        }
    }
}
