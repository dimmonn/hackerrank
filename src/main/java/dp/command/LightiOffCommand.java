package dp.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LightiOffCommand implements Command {
    private Light light;

    @Override
    public void execute() {
        light.switchOff();

    }
}
