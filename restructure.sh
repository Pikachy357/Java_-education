#!/usr/bin/env bash
# Реструктуризация репозитория Java_-education.
# Запускать из корня репозитория в Git Bash:  bash restructure.sh
set -e

# Переносит файл через git mv, при необходимости переименовывает класс
# и добавляет строку package в начало файла.
# $1 - старый путь, $2 - новая папка, $3 - новое имя класса (без .java), $4 - старое имя класса
move() {
  local src="$1" dir="$2" newcls="$3" oldcls="$4"
  local pkg="${dir#src/}"; pkg="${pkg//\//.}"
  mkdir -p "$dir"
  git mv "$src" "$dir/$newcls.java"
  local f="$dir/$newcls.java"
  if [ "$oldcls" != "$newcls" ]; then
    sed -i "s/\b$oldcls\b/$newcls/g" "$f"
  fi
  sed -i "1s/^/package $pkg;\n\n/" "$f"
}

M="Mart 2026 Kontest/Competitions"
P="Mart 2026 Kontest/Practice and neetcode"
S="september-2026-contest"

# --- Контест, март 2026 ---
D=src/contests/c2026_03
move "$M/kontest.java"   $D Kontest1  kontest
for n in 2 3 4 5 6 9 10 11; do move "$M/Kontest$n.java" $D Kontest$n Kontest$n; done
move "$M/kontest7.java"  $D Kontest7  kontest7
move "$M/kontest8.java"  $D Kontest8  kontest8

# --- Первые практические задачи и NeetCode ---
D=src/practice/basics
for c in Ambulance Axaxa Bunker ControlFlowDemo Hello Inizal IsAnagram IsPalindrom \
         IsValid Main MaxProfit One Pingpong ReadSquare Rebus Search Solution \
         Solution2 Solution3 TopKFrequent TwoSum Twoo; do
  move "$P/$c.java" $D $c $c
done
move "$P/Wood_buket.java" $D WoodBuket Wood_buket

# --- Контесты, сентябрь 2026 (по дням) ---
move "$S/Competitions 07-09-2026/Task1.java"  src/contests/c2026_09_07 Task1 Task1
move "$S/Competitions 10-09-2026/Task_1.java" src/contests/c2026_09_10 Task1 Task_1
move "$S/Competitions 14-09-2026/Task_1.java" src/contests/c2026_09_14 Task1 Task_1
move "$S/Competitions 16-09-2026/Task_1.java" src/contests/c2026_09_16 Task1 Task_1
move "$S/Competitions 16-09-2026/Task_2.java" src/contests/c2026_09_16 Task2 Task_2

# --- Практические блоки, сентябрь 2026 ---
move "$S/practic block 1/1.1 Stack/Bracket.java"   src/practice/block1/stack   Bracket Bracket
move "$S/practic block 1/1.2 Postfix/Postfix.java" src/practice/block1/postfix Postfix Postfix
move "$S/practice block 2/2.1 Queue/Task_1.java"   src/practice/block2/queue   Task1 Task_1
move "$S/practice block 2/2.1 Queue/Task_2.java"   src/practice/block2/queue   Task2 Task_2
move "$S/practice block 3/3.1 Quicksort/Task_1.java" src/practice/block3/quicksort Task1 Task_1

# --- Убираем из Git служебные файлы IDE и скомпилированный код ---
git rm -r -q --cached .idea out Java_-education.iml
printf '/.idea/\n/out/\n*.iml\n*.class\n' > .gitignore
git add .gitignore

# Удаляем опустевшие старые папки (в них могли остаться только локальные файлы)
rm -rf "Mart 2026 Kontest" "$S" 2>/dev/null || true

echo "Готово. Проверь: git status"
