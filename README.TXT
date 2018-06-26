To clean:
ant -buildfile src/build.xml clean

To compile: 
ant -buildfile src/build.xml all

To run
ant -buildfile src/build.xml run -Darg0=/home/girish_kurkute_assign_3/input.txt -Darg1=/home/girish_kurkute_assign_3/output.txt -Darg2=0



For each entry in input file , the state (Operation ID) is printed in output file. The  average travelers per day and aveerage prohibited items per day is recomputed for every time and current state is updated every time.

Assumption
For example 
Day:1;TOD:09:00;Airline:JetBlue;Item:Comb
Day:2;TOD:11:50;Airline:JetBlue;Item:BoardGame
Day:2;TOD:11:50;Airline:AmericanAirlines;Item:Clothes
Day:4;TOD:12:00;Airline:JetBlue;Item:GameSystem
Day:4;TOD:15:00;Airline:United;Item:Umbrella
Day:4;TOD:15:00;Airline:JetBlue;Item:Knife

Now for above input Number of days is 3.
