package performancemap;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    @FunctionalInterface
    public interface DocumentPopulator {
        void populate(String metricTypeValueFromFile, DAPerformanceDocument.DAPerformanceDocumentBuilder documentBuilder);
    }

    Map<Pair<MetricGroupEnum, String>, Map<MetricType, DocumentPopulator>> metGrpAggTypeToDocTranslatorMap() {
        return ImmutableMap.<Pair<MetricGroupEnum, String>, Map<MetricType, DocumentPopulator>>builder()
                .put(new Pair<>(MetricGroupEnum.POD, PerformanceAggregationType.DAY),
                        ImmutableMap.<MetricType, DocumentPopulator>builder()
                                .put(MetricType.STORE_ID, (metricType, documentBuilder) -> documentBuilder.storeId(metricType))
                                .put(MetricType.STATION_CODE, (metricType, documentBuilder) -> documentBuilder.stationCode(metricType))
                                .put(MetricType.DATE_QUALIFIER, (metricType, documentBuilder) -> documentBuilder.dateQualifier(metricType))
                                .put(MetricType.COD_DELIVERED, (metricType, documentBuilder) -> documentBuilder.codDelivered(metricType))
                                .put(MetricType.DPOD_PERF, (metricType, documentBuilder) -> documentBuilder.dpodPerf(metricType))
                                .put(MetricType.DA_INITIATED_PERF, (metricType, documentBuilder) -> documentBuilder.daInitiatedPerf(metricType))
                                .put(MetricType.AUTOPAYLINK_PERF, (metricType, documentBuilder) -> documentBuilder.autopaylinkPerf(metricType))
                                .put(MetricType.CLR_PERF, (metricType, documentBuilder) -> documentBuilder.clrPerf(metricType))
                                .put(MetricType.OVERALL_POD_PERF, (metricType, documentBuilder) -> documentBuilder.overallPodPerf(metricType))
                                .put(MetricType.AGGREGATION_TYPE, (metricType, documentBuilder) -> documentBuilder.aggregationType(metricType))
                                .build())
                .build();
    }

    ImmutableMap<Pair<MetricGroupEnum, String>, List<MetricType>> getMetGroupAggToMetIdxMap() {
        return ImmutableMap.<Pair<MetricGroupEnum, String>, List<MetricType>>builder()
                .put(new Pair<>(MetricGroupEnum.POD, PerformanceAggregationType.DAY), ImmutableList.of(MetricType.STORE_ID,
                        MetricType.STATION_CODE, MetricType.DATE_QUALIFIER,
                        MetricType.COD_DELIVERED,
                        MetricType.DPOD_PERF,
                        MetricType.DA_INITIATED_PERF,
                        MetricType.AUTOPAYLINK_PERF,
                        MetricType.CLR_PERF,
                        MetricType.OVERALL_POD_PERF,
                        MetricType.AGGREGATION_TYPE))
                .put(new Pair<>(MetricGroupEnum.POD, PerformanceAggregationType.MONTH), ImmutableList.of(MetricType.STORE_ID,
                        MetricType.STATION_CODE, MetricType.DATE_QUALIFIER,
                        MetricType.COD_DELIVERED,
                        MetricType.DPOD_PERF,
                        MetricType.DA_INITIATED_PERF,
                        MetricType.AUTOPAYLINK_PERF,
                        MetricType.CLR_PERF,
                        MetricType.OVERALL_POD_PERF,
                        MetricType.AGGREGATION_TYPE,
                        MetricType.DPOD_TRANSACTIONS,
                        MetricType.DPOD_BASE_TARGET,
                        MetricType.DPOD_STRETCH_TARGET1,
                        MetricType.DPOD_STRETCH_TARGET2,
                        MetricType.OVERALL_POD_TARGET,
                        MetricType.TARGET_STATUS,
                        MetricType.FINAL_INCENTIVE))
                .put(new Pair<>(MetricGroupEnum.MAQ, PerformanceAggregationType.DAY), ImmutableList.of(MetricType.DATE_QUALIFIER,
                        MetricType.ONBOARDING_COMPLETED,
                        MetricType.STORE_ID, MetricType.AGGREGATION_TYPE))
                .put(new Pair<>(MetricGroupEnum.MAQ, PerformanceAggregationType.MONTH), ImmutableList.of(MetricType.DATE_QUALIFIER,
                        MetricType.STATION_CODE,
                        MetricType.STORE_ID,
                        MetricType.CURRENT_MONTH_ACQUISITION,
                        MetricType.ACQ_INCENTIVE,
                        MetricType.AMR_BASE,
                        MetricType.ACTIVE_MERCHANTS,
                        MetricType.AMR_PER,
                        MetricType.AMR_INCENTIVE,
                        MetricType.AMR_INCENTIVE_STATUS,
                        MetricType.AGGREGATION_TYPE))
                .put(new Pair<>(MetricGroupEnum.KYC, PerformanceAggregationType.DAY), ImmutableList.of(MetricType.DATE_QUALIFIER,
                        MetricType.STATION_CODE,
                        MetricType.STORE_ID,
                        MetricType.FLAGGED_CUSTOMER,
                        MetricType.KYC_CUSTOMER,
                        MetricType.FLAGGED_KYC_CUSTOMER,
                        MetricType.FLAGGED_PER,
                        MetricType.KYC_INCEN,
                        MetricType.AGGREGATION_TYPE))
                .put(new Pair<>(MetricGroupEnum.KYC, PerformanceAggregationType.MONTH), ImmutableList.of(MetricType.DATE_QUALIFIER,
                        MetricType.STATION_CODE,
                        MetricType.STORE_ID,
                        MetricType.FLAGGED_CUSTOMER,
                        MetricType.KYC_CUSTOMER,
                        MetricType.FLAGGED_KYC_CUSTOMER,
                        MetricType.FLAGGED_PER,
                        MetricType.KYC_INCEN,
                        MetricType.AGGREGATION_TYPE))
                .build();
    }

    // perf_pod_day_123.csv
    DAPerformanceDocument createDAPerformanceDocument(String fileName, String[] line) {

        String[] token = fileName.split("_");
        String metricType = token[1];
        String aggType = token[2];
        MetricGroupEnum metricGroup = MetricGroupEnum.getValueByCode(metricType);

        DAPerformanceDocument.DAPerformanceDocumentBuilder documentBuilder = DAPerformanceDocument.builder();

        String aggregationType = Arrays.stream(PerformanceAggregationType.values())
                .filter(str -> str.equalsIgnoreCase(aggType))
                .collect(Collectors.toList()).get(0);

        Map<Pair<MetricGroupEnum, String>, Map<MetricType, DocumentPopulator>> documentTranslatorMap = metGrpAggTypeToDocTranslatorMap();

        //Map<MetricType, DocumentPopulator>
        documentTranslatorMap.get(new Pair<>(metricGroup, aggregationType))
                // k = MetricType.STORE_ID, v= (metricType, documentBuilder) -> documentBuilder.storeId(metricType)
                // for each MetricType -> find index at which its value is present -> read line[index] -> populate the same in documentBuilder
                .forEach((metricTypee, documentPopulator) -> documentPopulator.populate(line[getMetricTypeIndex(metricGroup, aggregationType, metricTypee)], documentBuilder));

        DAPerformanceDocument document = documentBuilder.fileProcessTime(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC))
                .lastUpdateTime(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)).build();
        document.setDateAggregationType(document.getStoreId()+"_"+ document.getDateQualifier());

        return document;
    }

    private int getMetricTypeIndex(MetricGroupEnum metricGroupEnum, String performanceAggregationType, MetricType metricType) {
        ImmutableMap<Pair<MetricGroupEnum, String>, List<MetricType>> idxMap = getMetGroupAggToMetIdxMap();
        return idxMap.get(new Pair<>(metricGroupEnum, performanceAggregationType)).indexOf(metricType);
    }

    public static void main(String[] args) {
        Test test = new Test();

        String[] lines = new String[10];
        lines[0]="123";
        lines[1]="ABCD";
        lines[2]="1-1-2021";
        lines[3]="COD";
        lines[4]="DPOD";
        lines[5]="DA";
        lines[6]="AUTO";
        lines[7]="CLR";
        lines[8]="OVERAL";
        lines[9]="AGGTYPE";

        DAPerformanceDocument daPerformanceDocument = test.createDAPerformanceDocument("perf_pod_day_123.csv", lines);
        System.out.println(daPerformanceDocument);
    }

}
