#!/bin/bash
for d in ./Day*; do
  if [ -d "$d" ]; then
    cd "$d"

    IFS=' '
    read -a strarr <<< "$d"
    echo "Day ${strarr[1]}"

    ./main.lua

    code=$?
    if [ $code -ne 0 ]; then
      exit $code
    fi

    echo
    cd ..
  fi
done
