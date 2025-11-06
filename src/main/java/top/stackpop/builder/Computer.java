package top.stackpop.builder;

public class Computer {
    private String cpu;

    private String memory;

    private String storage;

    private String gpu;

    private String motherboard;

    private Computer(Builder builder){
        this.cpu=builder.cpu;
        this.memory=builder.memory;
        this.storage=builder.storage;
        this.gpu=builder.gpu;
        this.motherboard = builder.motherboard;

    }
    
    
    @Override
    public String toString() {
        return "Computer [cpu=" + cpu + ", memory=" + memory + ", storage=" + storage + ", gpu=" + gpu
                + ", motherboard=" + motherboard + "]";
    }


    public String getCpu() {
        return cpu;
    }

    public String getMemory() {
        return memory;
    }

    public String getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public static class Builder{
        private String cpu;

        private String memory;

        private String storage;

        private String gpu;

        private String motherboard;

        public Builder(String cpu, String memory){
            this.cpu = cpu;
            this.memory = memory;
        }

        public Builder storage(String storage){
            this.storage=storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }
        
        public Builder motherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Computer build(){
            if(cpu==null || memory ==null){
                throw new IllegalArgumentException("cpu and memory can not be null");
            }
            return new Computer(this);
        }
    }
}
