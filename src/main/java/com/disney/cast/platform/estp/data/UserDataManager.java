/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.data;

import static com.disney.automation.servicetesting.config.Framework.CONFIGURATION;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.disney.automation.servicetesting.core.ApiTestResponse;
import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.common.api.snow.tables.SysUserTableApi;
import com.disney.cast.platform.common.api.snow.tables.model.SysUserTableRecord;
import com.disney.cast.platform.estp.test.api.ApiAuthLevel;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author luis.martinez
 */
public class UserDataManager {

    private static final String FILE_NAME = "VacationPlannerRewardsData.xlsx";
    private static final int GROUPS_SHEET_NUMBER = 10;

    /**
     * @return An user based on SysId on VacationPlannerRewardsData
     */
    public SysUserTableRecord getUser() {
        Workbook workbook = new XSSFWorkbook();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(FILE_NAME).getFile());
            FileInputStream excelFile = new FileInputStream(file);
            workbook.close();
            workbook = new XSSFWorkbook(excelFile);
            Sheet dataTypeSheet = workbook.getSheetAt(GROUPS_SHEET_NUMBER);
            Iterator<Row> iterator = dataTypeSheet.iterator();
            iterator.next();
            Row currentRow;
            Cell userCell;
            currentRow = iterator.next();
            userCell = currentRow.getCell(0);
            if (userCell != null) {
                userCell = currentRow.getCell(0);
                return getUserById(userCell.getStringCellValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getEmployeeNumber(String id) throws Exception {
        return getUserById(id).getEmployeeNumber();
    }

    public SysUserTableRecord getUserById(String id) throws Exception {
        String parameters = "?sysparm_query=sys_id=" + id;
        SysUserTableApi userTableApi = new SysUserTableApi();
        ApiTestResponse response = userTableApi.get(CONFIGURATION
                .getClientsMap(ApiAuthLevel.values())
                .get(ApiAuthLevel.SNOWADMIN.toString()), parameters);
        SysUserTableRecord userRecord = response
                .getBodyObject(new TypeReference<Result<List<SysUserTableRecord>>>() {
                })
                .getResult()
                .get(0);
        return userRecord;
    }

    public SysUserTableRecord getUserByName(String userName) throws Exception {
        String parameters = "?sysparm_query=user_name=" + userName;
        SysUserTableApi userTableApi = new SysUserTableApi();
        ApiTestResponse response = userTableApi.get(CONFIGURATION
                .getClientsMap(ApiAuthLevel.values())
                .get(ApiAuthLevel.SNOWADMIN.toString()), parameters);
        SysUserTableRecord userRecord = response
                .getBodyObject(new TypeReference<Result<List<SysUserTableRecord>>>() {
                })
                .getResult()
                .get(0);
        return userRecord;
    }

    public SysUserTableRecord getUserByPerner(String perner) throws MalformedURLException, Exception {
        String parameters = "?sysparm_query=employee_number=" + perner;
        SysUserTableApi userTableApi = new SysUserTableApi();
        ApiTestResponse response = userTableApi.get(
                CONFIGURATION.getClientsMap(ApiAuthLevel.values()).get(ApiAuthLevel.SNOWADMIN.toString()),
                parameters);
        SysUserTableRecord userRecord = response
                .getBodyObject(new TypeReference<Result<List<SysUserTableRecord>>>() {
                })
                .getResult()
                .get(0);
        return userRecord;
    }
}