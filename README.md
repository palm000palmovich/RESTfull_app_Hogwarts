This is a full-fledged REST-API application, inspired by Harry Potter.

Let's start with Student's actions!
Login to the application Postman and enter the Get-request: http://localhost:8080/student
In this link you can see all your Students but now it's just empty array. So let's create a few Students!
Students - is a class that have properties:
1) **Long id**;  -no comments required, it's a simply counter of your students mister dad-creator!
2) **String name**; -I hope you don't think this is a characteristic of his hair, eyes or gender. that's right man, it's just a name
3) **int age**; -I know it's difficult, but you can do it. Aaaand... This is age, you're doing great!

Switch to POST-mode and in body in Json-format enter the properties of your students, for example:

`{
"id": 1,
"name": "Freaking Bird",
"age": 31
}`


                P.S. I'm not a bird-hater, it's just an absurd irony

Then you can feel free to enter Get-request: http://localhost:8080/student and look at your creations.

Since this is a REST api application, I did not forget about the other 2 principles: 
PUT and DELETE. For a moment, we have already checked the first 2: GET and POST.

Let's try to destroy one of your creations? Enter http://localhost:8080/student/{id} -instead of {id} there should be 
the id of one of your students. Who would you like to destroy?

So, you destroyed it, now let's fix the one you don't like? You can't destroy everyone :)

Switch to PUT-mode, enter http://localhost:8080/student and come back to body.
You can change our Freaking Bird to "Pretty Bird" and rejuvenate her a little, about 20 years :)
`{
"id": 1,
"name": "Pretty Bird",
"age": 11
}`

So, be careful, the id must remain the same, since the check for presence in the map is based 
on the id.

So, with Faculty-operations everything is the same, but the main request is 
http://localhost:8080/faculty and that's pretty logical and class Faculty has a little different
properties:
1) **Long id**;  -again, id
2) **String name**; -I hope you understand that it is name of faculty
3) **String color**; -if you remember, in the film all the faculties had colors. 
If yes, then make Slytherin brown :)

I forgot to mention something important. I took into account the human factor in absolutely all 
scenarios and made sure that the server displays a 404 error for every incorrect request.

In this project I practiced with REST api, a very important function of the http protocol.


P.S. Love you Java ♡

public class ReplyFromJava { public static void main(String[] args) { System.out.println("Love you too bro)"; } }
