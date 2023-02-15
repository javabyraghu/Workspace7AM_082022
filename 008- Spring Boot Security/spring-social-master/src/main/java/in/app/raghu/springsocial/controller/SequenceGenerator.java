package in.app.raghu.springsocial.controller;


import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Enumeration;


public class SequenceGenerator {
    private static final int TOTAL_BITS = 64;
    private static final int EPOCH_BITS = 42;
    private static final int MACHINE_ID_BITS = 10;
    private static final int SEQUENCE_BITS = 12;

    private static final int maxMachineId = (int)(Math.pow(2, MACHINE_ID_BITS) - 1);
    private static final int maxSequence = (int)(Math.pow(2, SEQUENCE_BITS) - 1);

    private static final long CUSTOM_EPOCH = 1420070400000L;

    private final int machineId;

    private long lastTimestamp = -1L;
    private long sequence = 0L;

    public SequenceGenerator(int machineId) {
        if(machineId < 0 || machineId > maxMachineId) {
            throw new IllegalArgumentException(String.format("MachineId must be between %d and %d", 0, maxMachineId));
        }
        this.machineId = machineId;
    }

    public SequenceGenerator() {
        this.machineId = createMachineId();
    }


    public long nextId() {
        long currentTimestamp = timestamp();

        synchronized (this) {
            if(currentTimestamp < lastTimestamp) {
                throw new IllegalStateException("Invalid System Clock!");
            }

            if (currentTimestamp == lastTimestamp) {
                sequence = (sequence + 1) & maxSequence;
                if(sequence == 0) {
                    currentTimestamp = waitNextMillis(currentTimestamp);
                }
            } else {
                sequence = 0;
            }

            lastTimestamp = currentTimestamp;
        }

        long id = currentTimestamp << (TOTAL_BITS - EPOCH_BITS);
        id |= (machineId << (TOTAL_BITS - EPOCH_BITS - MACHINE_ID_BITS));
        id |= sequence;
        return id;
    }


    private static long timestamp() {
        return Instant.now().toEpochMilli() - CUSTOM_EPOCH;
    }

    private long waitNextMillis(long currentTimestamp) {
        while (currentTimestamp == lastTimestamp) {
            currentTimestamp = timestamp();
        }
        return currentTimestamp;
    }

    private int createMachineId() {
        int machineId;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    for(int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X", mac[i]));
                    }
                }
            }
            machineId = sb.toString().hashCode();
        } catch (Exception ex) {
            machineId = (new SecureRandom().nextInt());
        }
        machineId = machineId & maxMachineId;
        return machineId;
    }
}