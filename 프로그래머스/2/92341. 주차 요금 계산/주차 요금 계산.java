import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<String[]>> carRecords = getCarRecords(records);
        return calculateParkingFees(fees, carRecords);
    }

    private Map<String, List<String[]>> getCarRecords(String[] records) {
        Map<String, List<String[]>> carRecords = new TreeMap<>();
        for (String record : records) {
            String[] parts = record.split(" ");
            String carNumber = parts[1];
            carRecords.computeIfAbsent(carNumber, k -> new ArrayList<>()).add(parts);
        }
        return carRecords;
    }

    private int[] calculateParkingFees(int[] fees, Map<String, List<String[]>> carRecords) {
        int[] answer = new int[carRecords.size()];
        int index = 0;
        for (Map.Entry<String, List<String[]>> entry : carRecords.entrySet()) {
            String carNumber = entry.getKey();
            List<String[]> records = entry.getValue();
            int totalMinutes = getTotalParkingMinutes(records);
            int parkingFee = calculateParkingFee(fees, totalMinutes);
            answer[index++] = parkingFee;
        }
        return answer;
    }

    private int getTotalParkingMinutes(List<String[]> records) {
        int totalMinutes = 0;
        String inTime = null;
        for (String[] record : records) {
            String time = record[0];
            String status = record[2];
            if ("IN".equals(status)) {
                inTime = time;
            } else {
                totalMinutes += calculateParkingMinutes(inTime, time);
                inTime = null;
            }
        }
        if (inTime != null) {
            totalMinutes += calculateParkingMinutes(inTime, "23:59");
        }
        return totalMinutes;
    }

    private int calculateParkingMinutes(String inTime, String outTime) {
        String[] inTimeParts = inTime.split(":");
        String[] outTimeParts = outTime.split(":");
        int inMinutes = Integer.parseInt(inTimeParts[0]) * 60 + Integer.parseInt(inTimeParts[1]);
        int outMinutes = Integer.parseInt(outTimeParts[0]) * 60 + Integer.parseInt(outTimeParts[1]);
        return outMinutes - inMinutes;
    }

    private int calculateParkingFee(int[] fees, int totalMinutes) {
        int freeMinutes = fees[0];
        int basicFee = fees[1];
        int unitMinutes = fees[2];
        int unitFee = fees[3];

        if (totalMinutes <= freeMinutes) {
            return basicFee;
        } else {
            int extraMinutes = totalMinutes - freeMinutes;
            int extraFee = (int) Math.ceil((double) extraMinutes / unitMinutes) * unitFee;
            return basicFee + extraFee;
        }
    }
}
