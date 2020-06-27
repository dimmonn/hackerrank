package dp.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LightOnCommand implements Command {
    private Light light;

    @Override
    public void execute() {
        light.switchOn();
    }

    public static void main(String[] args) {
        new RemoteControl(new LightOnCommand(new Light())).hitButton();
        new RemoteControl(new LightiOffCommand(new Light())).hitButton();
    }
}
