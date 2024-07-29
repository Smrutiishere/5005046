    public class BuilderPatternTest {
        public static void main(String[] args) {
            // Create a high-end computer
            Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .build();
    
            // Create a budget computer
            Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("500GB HDD")
                .build();
    
            // Print out the details of the computers
            System.out.println("Gaming PC Configuration:");
            System.out.println("CPU: " + gamingPC.getCPU());
            System.out.println("RAM: " + gamingPC.getRAM());
            System.out.println("Storage: " + gamingPC.getStorage());
            System.out.println("GPU: " + gamingPC.getGPU());
    
            System.out.println("\nOffice PC Configuration:");
            System.out.println("CPU: " + officePC.getCPU());
            System.out.println("RAM: " + officePC.getRAM());
            System.out.println("Storage: " + officePC.getStorage());
        }
    }

