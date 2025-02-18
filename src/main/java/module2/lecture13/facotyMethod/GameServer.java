package module2.lecture13.facotyMethod;

public class GameServer extends Computer {

        private String ram;

        private String hdd;

        private String cpu;

        public GameServer(String ram, String hdd, String cpu) {
            this.ram = ram;
            this.hdd = hdd;
            this.cpu = cpu;
        }

        @Override
        public String getRAM() {
            return this.ram;
        }

        @Override
        public String getHDD() {
            return this.hdd;
        }

        @Override
        public String getCPU() {
            return this.cpu;
        }
}
