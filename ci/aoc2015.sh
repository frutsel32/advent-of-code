#!/bin/bash
if [ -d aoc-commons/.m2/repository/io/frutsel_/adventofcode.common ]; then
    if [ -d 2015/.m2/repository/io/frutsel_/adventofcode.common ]; then
        rm -rf 2015/.m2/repository/io/frutsel_/adventofcode.common
    fi

    mv aoc-commons/.m2/repository/io/frutsel_/adventofcode.common 2015/.m2/repository/io/frutsel_/
fi
