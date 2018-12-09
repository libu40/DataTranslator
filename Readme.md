**Specifications**:

1. A data vendor delivery data in flat files. These flat files are in matrix format. The first row contains the column labels, the further rows are data rows. In the first column holds a data vendor specific identifier. Column separator is a tab.

Example:

COL0	COL1	COL2	COL3
ID1	VAL11	VAL12	VAL12
ID2	VAL21	VAL22	VAL23
...

2. There is a configuration file that lists the columns that we want to extract. We want to translate the columns to 'our' names. So this file contains two columns: first column with original label, second column with 'our' labels.

Example (skip column COL2):

COL0	OURID
COL1	OURCOL1
COL3	OURCOL3

3. There is an another configuration file that lists the data vendor specific identifiers, so the rows that we want to extract. Similar to point 2: these are translated to the values in column 2

Example (skip ID1):

ID2	OURID2

4. The task is to build a 'translator' that reads in these three files and produces output in the same structure: first row with 'our' column labels, further rows with the data we wanted to extract. The output file records don't have to be in the same order as the input.

Example: expected output based on the examples above:

OURID	OURCOL1	OURCOL3
OURID2	VAL21	VAL23

**Configuration** :

1. EmployeeInput.txt:
This is the Input file which contains the data to be transformed. 

2. ColumnExtractor.txt :
This contains the data which specifies the columns needs to be fetched and transformed to expected columns.

3. DataExtractor.txt :
This contains the data which specifies the required rows needs to be fetched and transformed to the expected identifiers.

**Execution** :

The main class DataTranslator needs to be executed which picks all the required input files and does the
transformation and the output file is generated in target folder with name EmployeeOutput.txt

**Notable points** :
1. The application has been tested with bulk records of 700 data in the Input file and working as expected.
The evaluators can place the high volume of data in the Input file and run batch to view the transformation.
Currently the Input file is filled with mock sample data format which can then be replaced with bulk records.

2. The unit test cases has been excluded from this project as It was not one of the expected outcome.




