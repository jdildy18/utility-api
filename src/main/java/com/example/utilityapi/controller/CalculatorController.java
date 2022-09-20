package com.example.utilityapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestParam int value1, @RequestParam @Valid int value2) {

        if (value2 == 0) {
            throw new IllegalArgumentException("Second Value Can Not Be Zero.");
        }

        return value1/value2;
    }

    @RequestMapping(value = "/calculator/square/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int square(@PathVariable @Valid int value) {

        int squareValue = value * value;

        if(value > 46340) {
            throw new IllegalArgumentException("Square value exceeds preset maximum limit.");
        }

        return squareValue;
    }
}
