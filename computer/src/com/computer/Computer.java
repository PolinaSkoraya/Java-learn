package com.computer;

public class Computer {
    private String company;
    private ComputerInfo info;

    public Computer(String company, String processor, Integer ramSize, OperatingSystem operatingSystem) {
        this.company = company;
        this.info = new ComputerInfo (processor, ramSize, operatingSystem);
    }

    public String getCompany() {
        return company;
    }

    public ComputerInfo getInfo() {
        return info;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setInfo(String processor, Integer ramSize, OperatingSystem operatingSystem) {
        this.info = new ComputerInfo (processor, ramSize, operatingSystem);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "company='" + company + '\'' +
                ", " + info;
    }

    private class ComputerInfo {
        private String processor;
        private Integer ramSize;
        private OperatingSystem operatingSystem;

        public ComputerInfo(String processor, Integer ramSize, OperatingSystem operatingSystem) {
            this.processor = processor;
            this.ramSize = ramSize;
            this.operatingSystem = operatingSystem;
        }

        public String getProcessor() {
            return processor;
        }

        public Integer getRamSize() {
            return ramSize;
        }

        public OperatingSystem getOperatingSystem() {
            return operatingSystem;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public void setRamSize(Integer ramSize) {
            this.ramSize = ramSize;
        }

        public void setOperatingSystem(String operatingSystem) { //encapsulation
            this.operatingSystem = new OperatingSystem (operatingSystem);
        }

        @Override
        public String toString() {
            return "processor='" + processor + '\'' +
                    ", ramSize=" + ramSize +
                    ", " + operatingSystem;
        }
    }

    public static class OperatingSystem {
        private String operatingSystem;

        public OperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
        }

        public String getOperatingSystem() {
            return operatingSystem;
        }

        public void setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
        }

        @Override
        public String toString() {
            return "operatingSystem='" + operatingSystem + '\'' +
                    '}';
        }
    }
}
