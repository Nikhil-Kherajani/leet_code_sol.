SELECT FirstName, LastName, City, Address.State from Person LEFT JOIN Address on Person.PersonId = Address.PersonId;