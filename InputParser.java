import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

enum Workclass {
	Private, 
	Self_emp_not_inc, 
	Self_emp_inc, 
	Federal_gov, 
	Local_gov, 
	State_gov, 
	Without_pay, 
	Never_worked		//null for unknown
}

enum Education {
	Bachelors, 
	Some_college, 
	n11th, 				//prefixed with n for numbers
	HS_grad, 
	Prof_school, 
	Assoc_acdm, 
	Assoc_voc, 
	n9th, 
	n7th_8th, 
	n12th, 
	Masters, 
	n1st_4th, 
	n10th, 
	Doctorate, 
	n5th_6th, 
	Preschool
}

enum MaritalStatus {
	Married_civ_spouse, 
	Divorced, 
	Never_married, 
	Separated, 
	Widowed, 
	Married_spouse_absent, 
	Married_AF_spouse
}

enum Occupation {
	Tech_support, 
	Craft_repair, 
	Other_service, 
	Sales, 
	Exec_managerial, 
	Prof_specialty, 
	Handlers_cleaners, 
	Machine_op_inspct, 
	Adm_clerical, 
	Farming_fishing, 
	Transport_moving, 
	Priv_house_serv, 
	Protective_serv, 
	Armed_Forces
}

enum Relationship {
	Wife, 
	Own_child, 
	Husband, 
	Not_in_family, 
	Other_relative, 
	Unmarried
}

enum Race {
	White, 
	Asian_Pac_Islander, 
	Amer_Indian_Eskimo, 
	Other, 
	Black
}

enum Sex {
	Female,
	Male
}

enum NativeCountry {
	United_States, 
	Cambodia, 
	England, 
	Puerto_Rico, 
	Canada, 
	Germany, 
	Outlying_US_Guam_USVI_etc_, 
	India, 
	Japan, 
	Greece, 
	South, 
	China, 
	Cuba, 
	Iran, 
	Honduras, 
	Philippines, 
	Italy, 
	Poland, 
	Jamaica, 
	Vietnam, 
	Mexico, 
	Portugal, 
	Ireland, 
	France, 
	Dominican_Republic, 
	Laos, 
	Ecuador, 
	Taiwan, 
	Haiti, 
	Columbia, 
	Hungary, 
	Guatemala, 
	Nicaragua, 
	Scotland, 
	Thailand, 
	Yugoslavia, 
	El_Salvador, 
	Trinadad_Tobago, 
	Peru, 
	Hong, 
	Holand_Netherlands
}

enum Classification {
	GreaterThan,
	LessThanEqual
}

class Attribute 
{
	int age;
	Workclass wClass;
	int fnlwgt;
	Education education;
	int educationNum;
	MaritalStatus marStatus;
	Occupation occupation;
	Relationship relationship;
	Race race;
	Sex sex;
	int capitalGain;
	int capitalLoss;
	int hoursPerWeek;
	NativeCountry nativeCountry;
	Classification classification;
}

class InputParser
{
	public static final int SIZE = 32561;
	public static void main(String ...args) throws IOException
	{
		FileReader in = null;
		
		Attribute data[] = new Attribute[SIZE];
		
		//Read the entire file into a String
		String file = new Scanner(new File("census-income.data.txt")).useDelimiter("\\Z").next(), temp;
		
		int strtIndex = 0, endIndex, i = SIZE;
		//ReadInput into arrays
		while(i-- != 0) {	
			
			data[SIZE-i-1] = new Attribute();
			
			//Age
			endIndex = file.indexOf(',', strtIndex);
			data[SIZE-i-1].age = Integer.parseInt(file.substring(strtIndex, endIndex));
			strtIndex = endIndex + 1;		//Index of space
			
			//Workclass
			endIndex = file.indexOf(',', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case "Private": 
					data[SIZE-i-1].wClass = Workclass.Private; break;
				case "Self-emp-not-inc": 
					data[SIZE-i-1].wClass = Workclass.Self_emp_not_inc; break;
				case "Self-emp-inc": 
					data[SIZE-i-1].wClass = Workclass.Self_emp_inc; break;
				case "Federal-gov": 
					data[SIZE-i-1].wClass = Workclass.Federal_gov; break;
				case "Local-gov": 
					data[SIZE-i-1].wClass = Workclass.Local_gov; break;
				case "State-gov": 
					data[SIZE-i-1].wClass = Workclass.State_gov; break;
				case "Without-pay": 
					data[SIZE-i-1].wClass = Workclass.Without_pay; break;
				case "Never-worked": 
					data[SIZE-i-1].wClass = Workclass.Never_worked; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
			//FNLWGT
			endIndex = file.indexOf(',', strtIndex);
			data[SIZE-i-1].fnlwgt = Integer.parseInt(file.substring(strtIndex+1, endIndex));
			strtIndex = endIndex + 1;		//Index of space
			
			//Education
			endIndex = file.indexOf(',', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case "Bachelors": 
					data[SIZE-i-1].education = Education.Bachelors; break;
				case "Some-college": 
					data[SIZE-i-1].education = Education.Some_college; break;
				case "11th": 
					data[SIZE-i-1].education = Education.n11th; break;
				case "HS-grad": 
					data[SIZE-i-1].education = Education.HS_grad; break;
				case "Prof-school": 
					data[SIZE-i-1].education = Education.Prof_school; break;
				case "Assoc-acdm": 
					data[SIZE-i-1].education = Education.Assoc_acdm; break;
				case "Assoc-voc": 
					data[SIZE-i-1].education = Education.Assoc_voc; break;
				case "9th": 
					data[SIZE-i-1].education = Education.n9th; break;
				case "7th-8th": 
					data[SIZE-i-1].education = Education.n7th_8th; break;
				case "12th": 
					data[SIZE-i-1].education = Education.n12th; break;
				case "Masters": 
					data[SIZE-i-1].education = Education.Masters; break;
				case "1st-4th": 
					data[SIZE-i-1].education = Education.n1st_4th; break;
				case "10th": 
					data[SIZE-i-1].education = Education.n10th; break;
				case "Doctorate": 
					data[SIZE-i-1].education = Education.Doctorate; break;
				case "5th-6th": 
					data[SIZE-i-1].education = Education.n5th_6th; break;
				case "Preschool": 
					data[SIZE-i-1].education = Education.Preschool; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
			//eduNum
			endIndex = file.indexOf(',', strtIndex);
			data[SIZE-i-1].educationNum = Integer.parseInt(file.substring(strtIndex+1, endIndex));
			strtIndex = endIndex + 1;		//Index of space
			
			//Marital Status
			endIndex = file.indexOf(',', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case "Married-civ-spouse": 
					data[SIZE-i-1].marStatus = MaritalStatus.Married_civ_spouse; break;
				case "Divorced": 
					data[SIZE-i-1].marStatus = MaritalStatus.Divorced; break;
				case "Never-married": 
					data[SIZE-i-1].marStatus = MaritalStatus.Never_married; break;
				case "Separated": 
					data[SIZE-i-1].marStatus = MaritalStatus.Separated; break;
				case "Widowed": 
					data[SIZE-i-1].marStatus = MaritalStatus.Widowed; break;
				case "Married-spouse-absent": 
					data[SIZE-i-1].marStatus = MaritalStatus.Married_spouse_absent; break;
				case "Married-AF-spouse": 
					data[SIZE-i-1].marStatus = MaritalStatus.Married_AF_spouse; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
			//Occupation
			endIndex = file.indexOf(',', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case "Tech-support": 
					data[SIZE-i-1].occupation = Occupation.Tech_support; break;
				case "Craft-repair": 
					data[SIZE-i-1].occupation = Occupation.Craft_repair; break;
				case "Other-service": 
					data[SIZE-i-1].occupation = Occupation.Other_service; break;
				case "Sales": 
					data[SIZE-i-1].occupation = Occupation.Sales; break;
				case "Exec-managerial": 
					data[SIZE-i-1].occupation = Occupation.Exec_managerial; break;
				case "Prof-specialty": 
					data[SIZE-i-1].occupation = Occupation.Prof_specialty; break;
				case "Handlers-cleaners": 
					data[SIZE-i-1].occupation = Occupation.Handlers_cleaners; break;
				case "Machine-op-inspct": 
					data[SIZE-i-1].occupation = Occupation.Machine_op_inspct; break;
				case "Adm-clerical": 
					data[SIZE-i-1].occupation = Occupation.Adm_clerical; break;
				case "Farming-fishing": 
					data[SIZE-i-1].occupation = Occupation.Farming_fishing; break;
				case "Transport-moving": 
					data[SIZE-i-1].occupation = Occupation.Transport_moving; break;
				case "Priv-house-serv": 
					data[SIZE-i-1].occupation = Occupation.Priv_house_serv; break;
				case "Protective-serv": 
					data[SIZE-i-1].occupation = Occupation.Protective_serv; break;
				case "Armed-Forces": 
					data[SIZE-i-1].occupation = Occupation.Armed_Forces; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
			//Relationship
			endIndex = file.indexOf(',', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case "Wife": 
					data[SIZE-i-1].relationship = Relationship.Wife; break;
				case "Own-child": 
					data[SIZE-i-1].relationship = Relationship.Own_child; break;
				case "Husband": 
					data[SIZE-i-1].relationship = Relationship.Husband; break;
				case "Not-in-family": 
					data[SIZE-i-1].relationship = Relationship.Not_in_family; break;
				case "Other-relative": 
					data[SIZE-i-1].relationship = Relationship.Other_relative; break;
				case "Unmarried": 
					data[SIZE-i-1].relationship = Relationship.Unmarried; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
			//Race
			endIndex = file.indexOf(',', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case "White": 
					data[SIZE-i-1].race = Race.White; break;
				case "Asian-Pac-Islander": 
					data[SIZE-i-1].race = Race.Asian_Pac_Islander; break;
				case "Amer-Indian-Eskimo": 
					data[SIZE-i-1].race = Race.Amer_Indian_Eskimo; break;
				case "Other": 
					data[SIZE-i-1].race = Race.Other; break;
				case "Black": 
					data[SIZE-i-1].race = Race.Black; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
			//Sex
			endIndex = file.indexOf(',', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case "Male": 
					data[SIZE-i-1].sex = Sex.Male; break;
				case "Female": 
					data[SIZE-i-1].sex = Sex.Female; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
			//CapitalGain
			endIndex = file.indexOf(',', strtIndex);
			data[SIZE-i-1].capitalGain = Integer.parseInt(file.substring(strtIndex+1, endIndex));
			strtIndex = endIndex + 1;		//Index of space
			
			//CpitalLoss
			endIndex = file.indexOf(',', strtIndex);
			data[SIZE-i-1].capitalLoss = Integer.parseInt(file.substring(strtIndex+1, endIndex));
			strtIndex = endIndex + 1;		//Index of space
			
			//HrsPerWeek
			endIndex = file.indexOf(',', strtIndex);
			data[SIZE-i-1].hoursPerWeek = Integer.parseInt(file.substring(strtIndex+1, endIndex));
			strtIndex = endIndex + 1;		//Index of space
			
			//NativeCountry
			endIndex = file.indexOf(',', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case "United-States": 
					data[SIZE-i-1].nativeCountry = NativeCountry.United_States; break;
				case "Cambodia": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Cambodia; break;
				case "England": 
					data[SIZE-i-1].nativeCountry = NativeCountry.England; break;
				case "Puerto-Rico": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Puerto_Rico; break;
				case "Canada": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Canada; break;
				case "Germany": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Germany; break;
				case "Outlying-US(Guam-USVI-etc)": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Outlying_US_Guam_USVI_etc_; break;
				case "India": 
					data[SIZE-i-1].nativeCountry = NativeCountry.India; break;
				case "Japan": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Japan; break;
				case "Greece": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Greece; break;
				case "South": 
					data[SIZE-i-1].nativeCountry = NativeCountry.South; break;
				case "China": 
					data[SIZE-i-1].nativeCountry = NativeCountry.China; break;
				case "Cuba": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Cuba; break;
				case "Iran": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Iran; break;
				case "Honduras": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Honduras; break;
				case "Philippines": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Philippines; break;
				case "Italy": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Italy; break;
				case "Poland": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Poland; break;
				case "Jamaica": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Jamaica; break;
				case "Vietnam": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Vietnam; break;
				case "Mexico": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Mexico; break;
				case "Portugal": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Portugal; break;
				case "Ireland": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Ireland; break;
				case "France": 
					data[SIZE-i-1].nativeCountry = NativeCountry.France; break;
				case "Dominican-Republic": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Dominican_Republic; break;
				case "Laos": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Laos; break;
				case "Ecuador": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Ecuador; break;
				case "Taiwan": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Taiwan; break;
				case "Haiti": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Haiti; break;
				case "Columbia": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Columbia; break;
				case "Hungary": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Hungary; break;
				case "Guatemala": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Guatemala; break;
				case "Nicaragua": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Nicaragua; break;
				case "Scotland": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Scotland; break;
				case "Thailand": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Thailand; break;
				case "Yugoslavia": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Yugoslavia; break;
				case "El-Salvador": 
					data[SIZE-i-1].nativeCountry = NativeCountry.El_Salvador; break;
				case "Trinadad&Tobago": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Trinadad_Tobago; break;
				case "Peru": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Peru; break;
				case "Hong": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Hong; break;
				case "Holand-Netherlands": 
					data[SIZE-i-1].nativeCountry = NativeCountry.Holand_Netherlands; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
			//Classification
			endIndex = file.indexOf('\n', strtIndex);
			temp = file.substring(strtIndex+1, endIndex);
			switch(temp) {
				case ">50K": 
					data[SIZE-i-1].classification = Classification.GreaterThan; break;
				case "<=50K": 
					data[SIZE-i-1].classification = Classification.LessThanEqual; break;
			}
			strtIndex = endIndex + 1;		//Index of space
			
		}
		
		//System.out.println(data[SIZE-1].marStatus + " " + data[SIZE-1].classification);
		
	}
}
