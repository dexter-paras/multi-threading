package performancemap;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DAPerformanceDocument {

    private String storeId;

    private String dateAggregationType;

    private String dateQualifier;

    private String aggregationType;

    private String fileName;

    private Long fileProcessTime;

    private Long lastUpdateTime;

    private String stationCode;

    /* POD daily or monthly metrics */
    private String codDelivered;

    private String dpodPerf;

    private String daInitiatedPerf;

    private String autopaylinkPerf;

    private String clrPerf;

    private String overallPodPerf;

    private String dpodTransactions;

    private String dpodBaseTarget;

    private String dpodStretchTarget1;

    private String dpodStretchTarget2;

    private String overallPodTarget;

    private String targetStatus;

    private String finalIncentive;

    /* MAQ daily or monthly metrics */
    private String onboardingCompleted;

    private String currentMonthAcquisition;

    private String acquisitionIncentives;

    private String amrBase;

    private String activeMerchants;

    private String amrPercentage;

    private String amrIncentive;

    private String amrIncentiveStatus;

    /* KYC daily or monthly metrics */
    private String flaggedCustomer;

    private String kycCustomer;

    private String flaggedKycCustomer;

    private String flagPer;

    private String kycIncentive;

    public static DAPerformanceDocumentBuilder builder() {
        return new DAPerformanceDocumentBuilder();
    }

    public static class DAPerformanceDocumentBuilder {
        private String storeId;
        private String dateAggregationType;
        private String dateQualifier;
        private String aggregationType;
        private String fileName;
        private Long fileProcessTime;
        private Long lastUpdateTime;
        private String stationCode;
        private String codDelivered;
        private String dpodPerf;
        private String daInitiatedPerf;
        private String autopaylinkPerf;
        private String clrPerf;
        private String overallPodPerf;
        private String dpodTransactions;
        private String dpodBaseTarget;
        private String dpodStretchTarget1;
        private String dpodStretchTarget2;
        private String overallPodTarget;
        private String targetStatus;
        private String finalIncentive;
        private String onboardingCompleted;
        private String currentMonthAcquisition;
        private String acquisitionIncentives;
        private String amrBase;
        private String activeMerchants;
        private String amrPercentage;
        private String amrIncentive;
        private String amrIncentiveStatus;
        private String flaggedCustomer;
        private String kycCustomer;
        private String flaggedKycCustomer;
        private String flagPer;
        private String kycIncentive;

        DAPerformanceDocumentBuilder() {
        }

        public DAPerformanceDocumentBuilder storeId(String storeId) {
            this.storeId = storeId;
            return this;
        }

        public DAPerformanceDocumentBuilder dateAggregationType(String dateAggregationType) {
            this.dateAggregationType = dateAggregationType;
            return this;
        }

        public DAPerformanceDocumentBuilder dateQualifier(String dateQualifier) {
            this.dateQualifier = dateQualifier;
            return this;
        }

        public DAPerformanceDocumentBuilder aggregationType(String aggregationType) {
            this.aggregationType = aggregationType;
            return this;
        }

        public DAPerformanceDocumentBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public DAPerformanceDocumentBuilder fileProcessTime(Long fileProcessTime) {
            this.fileProcessTime = fileProcessTime;
            return this;
        }

        public DAPerformanceDocumentBuilder lastUpdateTime(Long lastUpdateTime) {
            this.lastUpdateTime = lastUpdateTime;
            return this;
        }

        public DAPerformanceDocumentBuilder stationCode(String stationCode) {
            this.stationCode = stationCode;
            return this;
        }

        public DAPerformanceDocumentBuilder codDelivered(String codDelivered) {
            this.codDelivered = codDelivered;
            return this;
        }

        public DAPerformanceDocumentBuilder dpodPerf(String dpodPerf) {
            this.dpodPerf = dpodPerf;
            return this;
        }

        public DAPerformanceDocumentBuilder daInitiatedPerf(String daInitiatedPerf) {
            this.daInitiatedPerf = daInitiatedPerf;
            return this;
        }

        public DAPerformanceDocumentBuilder autopaylinkPerf(String autopaylinkPerf) {
            this.autopaylinkPerf = autopaylinkPerf;
            return this;
        }

        public DAPerformanceDocumentBuilder clrPerf(String clrPerf) {
            this.clrPerf = clrPerf;
            return this;
        }

        public DAPerformanceDocumentBuilder overallPodPerf(String overallPodPerf) {
            this.overallPodPerf = overallPodPerf;
            return this;
        }

        public DAPerformanceDocumentBuilder dpodTransactions(String dpodTransactions) {
            this.dpodTransactions = dpodTransactions;
            return this;
        }

        public DAPerformanceDocumentBuilder dpodBaseTarget(String dpodBaseTarget) {
            this.dpodBaseTarget = dpodBaseTarget;
            return this;
        }

        public DAPerformanceDocumentBuilder dpodStretchTarget1(String dpodStretchTarget1) {
            this.dpodStretchTarget1 = dpodStretchTarget1;
            return this;
        }

        public DAPerformanceDocumentBuilder dpodStretchTarget2(String dpodStretchTarget2) {
            this.dpodStretchTarget2 = dpodStretchTarget2;
            return this;
        }

        public DAPerformanceDocumentBuilder overallPodTarget(String overallPodTarget) {
            this.overallPodTarget = overallPodTarget;
            return this;
        }

        public DAPerformanceDocumentBuilder targetStatus(String targetStatus) {
            this.targetStatus = targetStatus;
            return this;
        }

        public DAPerformanceDocumentBuilder finalIncentive(String finalIncentive) {
            this.finalIncentive = finalIncentive;
            return this;
        }

        public DAPerformanceDocumentBuilder onboardingCompleted(String onboardingCompleted) {
            this.onboardingCompleted = onboardingCompleted;
            return this;
        }

        public DAPerformanceDocumentBuilder currentMonthAcquisition(String currentMonthAcquisition) {
            this.currentMonthAcquisition = currentMonthAcquisition;
            return this;
        }

        public DAPerformanceDocumentBuilder acquisitionIncentives(String acquisitionIncentives) {
            this.acquisitionIncentives = acquisitionIncentives;
            return this;
        }

        public DAPerformanceDocumentBuilder amrBase(String amrBase) {
            this.amrBase = amrBase;
            return this;
        }

        public DAPerformanceDocumentBuilder activeMerchants(String activeMerchants) {
            this.activeMerchants = activeMerchants;
            return this;
        }

        public DAPerformanceDocumentBuilder amrPercentage(String amrPercentage) {
            this.amrPercentage = amrPercentage;
            return this;
        }

        public DAPerformanceDocumentBuilder amrIncentive(String amrIncentive) {
            this.amrIncentive = amrIncentive;
            return this;
        }

        public DAPerformanceDocumentBuilder amrIncentiveStatus(String amrIncentiveStatus) {
            this.amrIncentiveStatus = amrIncentiveStatus;
            return this;
        }

        public DAPerformanceDocumentBuilder flaggedCustomer(String flaggedCustomer) {
            this.flaggedCustomer = flaggedCustomer;
            return this;
        }

        public DAPerformanceDocumentBuilder kycCustomer(String kycCustomer) {
            this.kycCustomer = kycCustomer;
            return this;
        }

        public DAPerformanceDocumentBuilder flaggedKycCustomer(String flaggedKycCustomer) {
            this.flaggedKycCustomer = flaggedKycCustomer;
            return this;
        }

        public DAPerformanceDocumentBuilder flagPer(String flagPer) {
            this.flagPer = flagPer;
            return this;
        }

        public DAPerformanceDocumentBuilder kycIncentive(String kycIncentive) {
            this.kycIncentive = kycIncentive;
            return this;
        }

        public DAPerformanceDocument build() {
            return new DAPerformanceDocument(storeId, dateAggregationType, dateQualifier, aggregationType, fileName, fileProcessTime, lastUpdateTime, stationCode, codDelivered, dpodPerf, daInitiatedPerf, autopaylinkPerf, clrPerf, overallPodPerf, dpodTransactions, dpodBaseTarget, dpodStretchTarget1, dpodStretchTarget2, overallPodTarget, targetStatus, finalIncentive, onboardingCompleted, currentMonthAcquisition, acquisitionIncentives, amrBase, activeMerchants, amrPercentage, amrIncentive, amrIncentiveStatus, flaggedCustomer, kycCustomer, flaggedKycCustomer, flagPer, kycIncentive);
        }

        public String toString() {
            return "DAPerformanceDocument.DAPerformanceDocumentBuilder(storeId=" + this.storeId + ", dateAggregationType=" + this.dateAggregationType + ", dateQualifier=" + this.dateQualifier + ", aggregationType=" + this.aggregationType + ", fileName=" + this.fileName + ", fileProcessTime=" + this.fileProcessTime + ", lastUpdateTime=" + this.lastUpdateTime + ", stationCode=" + this.stationCode + ", codDelivered=" + this.codDelivered + ", dpodPerf=" + this.dpodPerf + ", daInitiatedPerf=" + this.daInitiatedPerf + ", autopaylinkPerf=" + this.autopaylinkPerf + ", clrPerf=" + this.clrPerf + ", overallPodPerf=" + this.overallPodPerf + ", dpodTransactions=" + this.dpodTransactions + ", dpodBaseTarget=" + this.dpodBaseTarget + ", dpodStretchTarget1=" + this.dpodStretchTarget1 + ", dpodStretchTarget2=" + this.dpodStretchTarget2 + ", overallPodTarget=" + this.overallPodTarget + ", targetStatus=" + this.targetStatus + ", finalIncentive=" + this.finalIncentive + ", onboardingCompleted=" + this.onboardingCompleted + ", currentMonthAcquisition=" + this.currentMonthAcquisition + ", acquisitionIncentives=" + this.acquisitionIncentives + ", amrBase=" + this.amrBase + ", activeMerchants=" + this.activeMerchants + ", amrPercentage=" + this.amrPercentage + ", amrIncentive=" + this.amrIncentive + ", amrIncentiveStatus=" + this.amrIncentiveStatus + ", flaggedCustomer=" + this.flaggedCustomer + ", kycCustomer=" + this.kycCustomer + ", flaggedKycCustomer=" + this.flaggedKycCustomer + ", flagPer=" + this.flagPer + ", kycIncentive=" + this.kycIncentive + ")";
        }
    }
}