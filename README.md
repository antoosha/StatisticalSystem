#Statictical system with cyclists records
Statistical system is a command-line program, which do some operation with data from input file.; 
Gets 3 arguments:
1) argument is input file in csv format with data
2) argument is commands to do with statistics
3) formats for output files

#####There are 4 commands to work with:
- **DM** find day with maximum number of records per day.
- **TR** find number of all cyclists passes throw all records.
- **TD** find number of all cyclists passes throw all records per each day.
- **MP** find most frequently driven participation(direction).

#####There are 2 output formats:
1) JSON
2) TXT

######Example input data
|    locations_id   | directions_id |      measured_from       |        measured_to       |     value     |
| ----------------- | ------------- | ------------------------ | ------------------------ | ------------- |
| camea-BC_ST-RABA  | camea-ST-BA   | 2019-12-31T23:00:00.000Z | 2019-12-31T23:05:00.000Z |       0       |

locations_id,directions_id,measured_from,measured_to,value

camea-BC_ST-RABA,camea-ST-BA,2019-12-31T23:00:00.000Z,2019-12-31T23:05:00.000Z,0

camea-BC_VF-ARUE,camea-BC_VF-AR,2020-01-25T06:45:00.000Z,2020-01-25T06:50:00.000Z,1