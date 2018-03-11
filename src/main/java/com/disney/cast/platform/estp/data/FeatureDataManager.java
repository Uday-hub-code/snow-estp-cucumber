package com.disney.cast.platform.estp.data;

import static com.disney.automation.servicetesting.config.Framework.CONFIGURATION;
import static com.disney.cast.platform.estp.data.ExcelSheets.FEATURE;
import static com.disney.cast.platform.estp.test.api.ApiAuthLevel.SNOWADMIN;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.common.data.AbstractDataManager;
import com.disney.cast.platform.estp.api.snow.tables.FeatureTableApi;
import com.disney.cast.platform.estp.api.snow.tables.model.FeatureTableRecord;
import com.disney.cast.platform.estp.test.api.ApiAuthLevel;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * @author walter.finkbeiner
 */
public class FeatureDataManager extends AbstractDataManager<FeatureTableApi, FeatureTableRecord> {

    protected FeatureDataManager() throws IOException {
        super(XLS.VACATION_PLANNER_REWARDS.get(), FEATURE);
    }

    public void setUnavailable(boolean unavailable) throws MalformedURLException, Exception {
        FeatureTableRecord unavailableFeature = getApi()
                .get(CONFIGURATION
                        .getClientsMap(ApiAuthLevel.values())
                        .get(SNOWADMIN.toString()), "?sysparm_query=u_key%3Dunavailable")
                .getBodyObject(new TypeReference<Result<ArrayList<FeatureTableRecord>>>() {
                })
                .getResult()
                .get(0);
        unavailableFeature.setUValue(unavailable);
        getApi().put(CONFIGURATION.getClientsMap(ApiAuthLevel.values()).get(SNOWADMIN.toString()),
                unavailableFeature);
    }

    @Override
    protected TypeReference<?> getTypeReference() {
        return new TypeReference<Result<FeatureTableRecord>>() {
        };
    }

    @Override
    protected FeatureTableRecord processRow(Row currentRow) {
        FeatureTableRecord feature = new FeatureTableRecord();
        Cell cell = currentRow.getCell(0);
        feature.setUValue(cell.getBooleanCellValue());
        cell = currentRow.getCell(1);
        feature.setUKey(cell.getStringCellValue());
        return feature;
    }

    public Set<FeatureTableRecord> add(int amount) throws Exception {
        return add(amount, (currentRow) -> {
            Cell cell = currentRow.getCell(0);
            return cell != null;
        });
    }

    @Override
    public void deleteAll() throws Exception {
        Set<String> doNotDeleteFeatures = new HashSet<>();
        doNotDeleteFeatures.addAll(
                Arrays.asList(
                        "pastredemptions.itemid", "pastredemptions.status", "pastredemptions.heading",
                        "pastredemptions.reward", "unavailable",
                        "debug"));
        List<FeatureTableRecord> features = getApi()
                .get(
                        getClient())
                .getBodyObject(new TypeReference<Result<List<FeatureTableRecord>>>() {
                })
                .getResult();
        for (FeatureTableRecord feature : features) {
            if (!doNotDeleteFeatures.contains(feature.getUKey())) {
                getApi().delete(
                        getClient(),
                        feature.getSysId());
            }
        }
    }

    @Override
    protected FeatureTableRecord postProcess(FeatureTableRecord instance) throws Exception {
        return instance;
    }

}
