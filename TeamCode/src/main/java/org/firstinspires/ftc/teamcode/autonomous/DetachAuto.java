package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.LinearActuator;
import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

/**
 * Untested auto. Time is not set yet. Detaches from lander by extending elevator, and then drives forward to fully detach
 */
@Autonomous
public class DetachAuto extends LinearOpMode {
    //TODO: Test till we find the time in millisecs for extending elevator, driving forward
    //L lets java know that the number should be represented as a long.
    private final long MILLISECONDS_TILL_FULL_ELEVATOR_EXTENSION = 0L;
    private final long MILLISECONDS_TO_DRIVE_FORWARD = 0L;

    HardwareManager hardware;

    //drive train motors
    DcMotor leftFrontDrive;
    DcMotor leftRearDrive;
    DcMotor rightFrontDrive;
    DcMotor rightRearDrive;

    //Elevator Linear Actuators
    LinearActuator leftActuator;
    LinearActuator rightActuator;

    @Override
    public void runOpMode() {
        hardware = new HardwareManager(hardwareMap);

        leftFrontDrive = hardware.leftFrontDrive;
        leftRearDrive = hardware.leftRearDrive;
        rightFrontDrive = hardware.rightFrontDrive;
        rightRearDrive = hardware.rightRearDrive;

        leftActuator = hardware.leftActuator;
        rightActuator = hardware.rightActuator;

        waitForStart();
        //extend elevator to full. Assumes positive voltage extends the elevator
        leftActuator.setVolt(1);
        rightActuator.setVolt(1);
        sleep(MILLISECONDS_TILL_FULL_ELEVATOR_EXTENSION);

        //drive forwards for predefined time in milliseconds
        leftFrontDrive.setPower(1);
        leftRearDrive.setPower(1);
        rightFrontDrive.setPower(1);
        rightRearDrive.setPower(1);
        sleep(MILLISECONDS_TO_DRIVE_FORWARD);

    }
}