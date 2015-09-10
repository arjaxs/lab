
class Rictusempra {


	//

	static main(args) {
		//Return keyword optional
		println callHarry(1)
		println callHarry(2)

		//No parenthesis No Semicolon
		println "Hogwartz"

		def malfoy=new Student()
		malfoy.name="Malfoy"
		malfoy.department.name="Slytherine"
		//malfoy.setId("1");

		/*###################################
		 * Safe dereferencing
		 * */

		//Java way

		if (malfoy != null) {
			if (malfoy.getDepartment() != null) {
				System.out.println("Hmmm the age old Java way of null checking");
				System.out.println(malfoy.getDepartment().getName());
			}
		}
		if (malfoy.getName() != null && malfoy.getName().length() > 0) {
			System.out.println("Its there in Java");
		}

		//Groovy way

		if (malfoy?.id) {
			println "Its there in "
		}else{
			println "Its not there in Groovy"
		}




		println """
This is the Groovy way of dereferencing.
Isn't it cool ??

"""
		println malfoy?.department?.name

		//Catch any exception
		try {
			String s
			s.test
		} catch (any) {
			println any
		}
		
		
		//// GStrings
		
		//Java
		System.out.println("My name is :" +malfoy.getName()+
    " I belong to " +
    malfoy.getDepartment().getName());


//Groovy
println """
##############Groovy Way####################
My name is : ${malfoy?.name}
I belong to : ${malfoy?.department?.name}
"""



//Collections

def list = [1, 4, 6, 9]

// by default, keys are Strings, no need to quote them
def map = [CA: 'California', MI: 'Michigan']


//Iteration

list.each{
	
	println "list ${it}"
	}
println 4 in list
//assert 5 in list

def range = 10..20
def pattern = ~/fo*/

range.each{iteratorVariable->
	println "iteratorVariable: ${iteratorVariable}"
	}


// equivalent to add()
list << 5

println list[1]


//####################### MAPS
// add a new key value pair
map << [WA: 'Washington']
// subscript notation
println map['CA'] 
// property notation
println map.WA 

// matches() strings against patterns
println 'foo' =~ pattern



////Switch

def x = 1.23
def result = ""
switch (x) {
	case "Harry": result = "found Harry"
	// lets fall through
	case "Potter": result += "Potter"
	case [4, 5, 6, 'inList']:
		result = "list"
		break
	case 12..30:
		result = "range"
		break
	case Integer:
		result = "integer"
		break
	case Number:
		result = "number"
		break
	default: result = "default"
}
println "Switch result"
assert result == "number"

/*###############
 * I ahve defined a list above.
 * I am passing a closure to the list's iterator method 
 * */

	def closure = {
	println it*3}
	list.each (closure)
 
//Expando
	
	Expando dumbledore=new Expando()
	dumbledore.post="professor"
    dumbledore.age=600
	
	println "name:Dumbledore post :${dumbledore.post} age: ${dumbledore.age}"


	}

	def  static callHarry(n){

		if(n == 1) {
			"Harry"
		} else {
			"Potter"
		}
	}

}
