call b.bat
echo "PROGRAM STARTS"
java -jar ./build/libs/picard-2.5.0-gradle-6-ge5da53b-SNAPSHOT-all.jar CollectWgsMetrics INPUT=other.bam OUTPUT=out_CollectWgsMetrics.txt REFERENCE_SEQUENCE=genome.fa 