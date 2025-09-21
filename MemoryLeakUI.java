import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MemoryLeakUI extends JFrame {
    private long lastUpdateTime = -1;
    private long lastUsedMemory = -1;
    private double lastRateGBs = 0.0;

    private static List<Object> leakedObjects = new ArrayList<>();
    private JProgressBar memoryBar;
    private JLabel infoLabel;
    private JLabel ramDetailsLabel;
    private Timer timer;

    public MemoryLeakUI() {
        setTitle("Memory Leak Visualizer");
        setSize(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        memoryBar = new JProgressBar(0, 100);
        memoryBar.setStringPainted(true);

        infoLabel = new JLabel("Starting...", JLabel.CENTER);
        ramDetailsLabel = new JLabel("RAM Details", JLabel.CENTER);

        add(ramDetailsLabel, BorderLayout.NORTH);
        add(memoryBar, BorderLayout.CENTER);
        add(infoLabel, BorderLayout.SOUTH);

        setVisible(true);

        timer = new Timer(10, e -> updateMemoryUsage());
        timer.start();
    }

    private void createLeakedObjects() {
        for (int i = 0; i < 100_000; i++) {
            leakedObjects.add(new Object());
        }
    }

    private void updateMemoryUsage() {
        createLeakedObjects();

        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory();

        double usedGB = usedMemory / (1024.0 * 1024 * 1024);
        double maxGB = maxMemory / (1024.0 * 1024 * 1024);
        double totalGB = totalMemory / (1024.0 * 1024 * 1024);
        double freeGB = freeMemory / (1024.0 * 1024 * 1024);

        int usagePercent = (int) ((100.0 * usedMemory) / maxMemory);

        memoryBar.setValue(usagePercent);
        memoryBar.setString(String.format("%.2f GB / %.2f GB", usedGB, maxGB));

        long now = System.currentTimeMillis();
        double rateGBs = lastRateGBs;
        if (lastUpdateTime > 0 && lastUsedMemory > 0) {
            double deltaGB = (usedMemory - lastUsedMemory) / (1024.0 * 1024 * 1024);
            double deltaSec = (now - lastUpdateTime) / 1000.0;
            if (deltaSec > 0) {
                rateGBs = deltaGB / deltaSec;
            }
        }
        lastUpdateTime = now;
        lastUsedMemory = usedMemory;
        lastRateGBs = rateGBs;

        infoLabel.setText(String.format("Objects: %d | Memory Used: %.2f GB | Rate: %.2f GB/s", leakedObjects.size(), usedGB, rateGBs));

        ramDetailsLabel.setText(String.format(
            "JVM Heap: Used %.2f GB, Free %.2f GB, Total %.2f GB, Max %.2f GB | System RAM: %.2f GB total, %.2f GB free",
            usedGB, freeGB, totalGB, maxGB,
            getSystemTotalRAMGB(), getSystemFreeRAMGB()
        ));
    }

    private double getSystemTotalRAMGB() {
        try {
            com.sun.management.OperatingSystemMXBean os =
                (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory.getOperatingSystemMXBean();
            return os.getTotalPhysicalMemorySize() / (1024.0 * 1024 * 1024);
        } catch (Exception e) {
            return -1;
        }
    }

    private double getSystemFreeRAMGB() {
        try {
            com.sun.management.OperatingSystemMXBean os =
                (com.sun.management.OperatingSystemMXBean) java.lang.management.ManagementFactory.getOperatingSystemMXBean();
            return os.getFreePhysicalMemorySize() / (1024.0 * 1024 * 1024);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MemoryLeakUI::new);
    }
}