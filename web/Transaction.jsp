<%@include file="header.html" %>
<center><h2><i><u>Transaction Screen</u></i></center>

<center>
    <pre>
  User Saving   Account balance :  ${sessionScope.saving.getBalance()} <pre>
  User Checking Account balance : ${sessionScope.checking.getBalance()}  
    <form action="TransactionServlet" method=post><pre>
<h1>Choose The Following Option</h1><pre>
<h2>Account</h2><pre>
<input type="radio" name="account" value="saving"> Savings<pre>
 <input type="radio" name="account" value="checking"> Checking<pre>

<h2>Transaction</h2><pre>
<input type="radio" name="transaction" value="Credit"> Credit<br><pre>
<input type="radio" name="transaction" value="Debit"> Debit<br><pre>
 
Balance : <input typ=number name=balance size=20><pre>

<br>
<input type=submit value="submit"><br>
<input type=reset value="clear"><br><br> 

</form>
<%@include file="footer.jsp" %>