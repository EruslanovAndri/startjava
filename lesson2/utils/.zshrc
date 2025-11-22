alias check=java -jar utils/checkstyle-11.0.0-all.jar -c utils/startjava_checks.xml $1 | sed -E "s|.*:([0-9]+):([0-9]+):(.*)|\1:\2 \3|; s|.*:([0-9]+):(.*)|\1 \2|"
