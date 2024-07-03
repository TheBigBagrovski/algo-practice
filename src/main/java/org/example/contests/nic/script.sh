#!/bin/bash

exec > D:/Movies/vid/logfile.txt 2>&1

cameraNumber="$1"
year="$2"
month="$3"
day="$4"
time="$5"
duration="$6"

# Парсинг времени в ЧЧ и ММ
timeHour=$(echo "$time" | cut -d':' -f1)
timeMinute=$(echo "$time" | cut -d':' -f2)

basePath="D:/Movies/vid/$cameraNumber/"
listFilePath="D:/Movies/vid/mylist.txt"

# Создание пустого файла mylist.txt
touch "$listFilePath"

for ((i = 0; i < duration; i++)); do
    path=$(printf "%s/%s/%s/%02d_%02d.mp4" "$year" "$month" "$day" "$timeHour" "$timeMinute")

    if [ -f "$basePath$path" ]; then
        echo "$basePath$path" >> "$listFilePath"
    fi

    # Инкремент времени
    timeMinute=$((timeMinute + 1))
    if [ "$timeMinute" -ge 60 ]; then
        timeMinute=0
        timeHour=$((timeHour + 1))

        if [ "$timeHour" -ge 24 ]; then
            timeHour=0
            day=$((day + 1))

            # Определение количества дней в месяце
            case "$month" in
                1|3|5|7|8|10|12)
                    daysInMonth=31
                    ;;
                4|6|9|11)
                    daysInMonth=30
                    ;;
                2)
                    # Проверка високосного года
                    if [ $((year % 4)) -eq 0 ] && [ $((year % 100)) -ne 0 -o $((year % 400)) -eq 0 ]; then
                        daysInMonth=29
                    else
                        daysInMonth=28
                    fi
                    ;;
            esac

            if [ "$day" -gt "$daysInMonth" ]; then
                day=1
                month=$((month + 1))

                if [ "$month" -gt 12 ]; then
                    month=1
                    year=$((year + 1))
                fi
            fi
        fi
    fi
done