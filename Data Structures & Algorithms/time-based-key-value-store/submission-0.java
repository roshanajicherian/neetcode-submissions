class TimeMap {
    private HashMap<String, ArrayList<TimeInfo>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeInfo(timestamp, value));
    }

    public String get(String key, int timestamp) {
        ArrayList<TimeInfo> timeSeriesData = timeMap.get(key);
        String closestTillNow = "";
        if (timeSeriesData != null) {
            int l = 0, r = timeSeriesData.size() - 1;
            closestTillNow = "";
            while (l <= r) {
                int mid = (l + r) / 2;
                if (timeSeriesData.get(mid).timestamp == timestamp) {
                    return timeSeriesData.get(mid).value;
                }
                if (timeSeriesData.get(mid).timestamp < timestamp) {
                    closestTillNow = timeSeriesData.get(mid).value;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return closestTillNow;
    }
    public static class TimeInfo {
        int timestamp;
        String value;

        TimeInfo(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
