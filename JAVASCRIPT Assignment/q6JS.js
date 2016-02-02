function f1()
{
	username = document.getElementById("id1").value ;
	//alert(username);
	if (username.length == 0)
		alert("Enter user name");
	userage = document.getElementById("id2").value ;
	if(userage < 18)
		alert("User should be more than or equal to 18");
}
