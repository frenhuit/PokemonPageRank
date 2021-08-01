# Pokemon Page Rank

## Description

Adjust weight of each page using PageRank.

## Installation

* Make sure docker is installed.
* Add a hadoop container in the docker.

## Usage

To run the code, we need to create a jar file, put it into hadoop then run it.

In local git-bash:

* Create a *.jar file.
* In local git bash:
```
docker cp "local\path\to\PokemonPageRank.jar" HADOOP_CONTAINER_ID:PokemonPageRank.jar
```
* Copy files generated in pre-process(https://github.com/frenhuit/PokemonSearch#use-pagerank-to-optimize-search-result) into hadoop
```
docker cp "local\path\to\pokemon_links.txt" HADOOP_CONTAINER_ID:pokemon_links.txt
docker cp "local\path\to\pokemon_weights" HADOOP_CONTAINER_ID:pokemon_weights
```
* In docker namenode cli:
Create data folder:
```
hdfs dfs -mkdir data
hdfs dfs -mkdir data/tr
hdfs dfs -mkdir data/pr0
```
Copy local files into hadoop file system:
```
hdfs dfs -put pokemon_links.txt data/tr
hdfs dfs -put pokemon_weights data/pr0
```
Run hadoop:
```
hadoop jar PokemonPageRank.jar Driver data/tr data/pr data/inter 30
```
Download result into hadoop:
```
hdfs dfs -get data/pr30/part-r-00000 pokemon_weights_30
```
Copy result into the local folder:
```
docker cp HADOOP_CONTAINER_ID:pokemon_weights_30 "local\path\to\pokemon_weights_30"
```

* To restart:
```
hdfs dfs -rm -r -f data
```
