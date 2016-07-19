call b.bat
echo "PROGRAM STARTS"
java -jar ./build/libs/picard-unspecified-SNAPSHOT-all.jar CollectWgsMetrics INPUT=D:\other.bam OUTPUT=out_CollectWgsMetrics.txt REFERENCE_SEQUENCE=D:\genome.fa 