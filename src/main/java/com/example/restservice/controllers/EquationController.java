package com.example.restservice.controllers;

import com.example.restservice.*;
import com.example.restservice.exceptions.BadRequestException;
import com.example.restservice.exceptions.InternalServerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EquationController {
    private static final Logger logger = LogManager.getLogger(EquationController.class);
    @Autowired
    private Cache cache;
    @Autowired
    private Arithmetic arithmetic;
    @Autowired
    private ExcelBuilder excelBuilder;
    private final CounterThread counterThread = new CounterThread();

    @GetMapping("/equation")
    public List<Equation> equationController(@RequestParam(value = "a", defaultValue = "0") List<String> listA,
                                             @RequestParam(value = "b", defaultValue = "0") List<String> listB) {
        Synchronization.semaphore.release();
        try {
            logger.info("Successfully");
            List<EquationParameters> equationParametersList = new ArrayList<>();
            List<Equation> equationList = new ArrayList<>();
            createList(listA, listB, equationParametersList);

            equationList.addAll(equationParametersList.stream()
                    .filter(cache::searchEquation)
                    .map((equationParameters) ->
                    {
                        cache.getEquation(equationParameters).setEquation();
                        logger.info("The value is already in the cache");
                        return cache.getEquation(equationParameters);
                    })
                    .collect(Collectors.toList()));
            equationList.addAll(equationParametersList.stream()
                    .filter((equationParameters) -> !cache.searchEquation(equationParameters))
                    .map((equationParameters) ->
                    {
                        cache.addEquation(equationParameters, equationParameters.createEquation());
                        logger.info("The value is successfully added to cache");
                        return cache.getEquation(equationParameters);
                    })
                    .collect(Collectors.toList()));
            logger.info("List is ready to print");

            Comparator<Equation> comparatorMax = Comparator.comparing(Equation::getX);
            Comparator<Equation> comparatorMin = Comparator.comparing(Equation::getX);
            Comparator<Equation> comparatorMaxA = Comparator.comparing(Equation::getA);
            Comparator<Equation> comparatorMaxB = Comparator.comparing(Equation::getB);
            Comparator<Equation> comparatorMinA = Comparator.comparing(Equation::getA);
            Comparator<Equation> comparatorMinB = Comparator.comparing(Equation::getB);

            Equation min = equationList.stream().min(comparatorMin).get();
            Equation max = equationList.stream().max(comparatorMax).get();
            Equation maxA = equationList.stream().max(comparatorMaxA).get();
            Equation maxB = equationList.stream().max(comparatorMaxB).get();
            Equation minA = equationList.stream().min(comparatorMinA).get();
            Equation minB = equationList.stream().min(comparatorMinB).get();
            double average = equationList.stream().mapToDouble((equation) -> equation.getX()).average().getAsDouble();

            arithmetic.setMax(max.getX());
            arithmetic.setMin(min.getX());
            arithmetic.setMaxA(maxA.getA());
            arithmetic.setMaxB(maxB.getB());
            arithmetic.setMinA(minA.getA());
            arithmetic.setMinB(minB.getB());
            arithmetic.setAverage(average);

            Collection<Equation> equationCollection = cache.getCollection();
            excelBuilder.buildExcel(equationCollection);

            return equationList;
        } catch (NumberFormatException ex) {
            logger.error("User error");
            throw new BadRequestException();
        } catch (InternalServerException ex) {
            logger.error("Server error");
            throw new InternalServerException();
        }
    }

    public void createList(List<String> listA, List<String> listB, List<EquationParameters> equationParametersList) {
        if (listA.size() == listB.size()) {
            for (int i = 0; i < listA.size(); i++) {
                try {
                    int a = Integer.parseInt(listA.get(i));
                    int b = Integer.parseInt(listB.get(i));
                    EquationParameters equationParameters = new EquationParameters(a, b);
                    equationParametersList.add(equationParameters);
                } catch (NumberFormatException ex) {
                    logger.error("User error");
                    throw new BadRequestException();
                }
            }
        } else {
            logger.info("User error");
            throw new BadRequestException();
        }
    }
}

