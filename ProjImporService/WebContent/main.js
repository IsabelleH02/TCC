function getService() {
	setInterval(function() {
		lerDados();
	}, 20000); // Intervalo de tempo que o serviço será chamado
}
// leitura do ThingSpeak
function lerDados() {
	$.get("https://api.thingspeak.com/channels/318126/fields/1.json?results=2",
			function(data, status) {
		//inserindo os dados na tabela
		myFunction(data.channel.id,
				   data.channel.name,
				   data.feeds[0].field1,
				   data.channel.created_at,
				   data.channel.updated_at);
				//Enviar dados para o Servlet
				$.post("ServDados", {
					id : data.channel.id,
					name : data.channel.name,
					field1 : data.feeds[0].field1,
					created_at : data.channel.created_at,
					updated_at : data.channel.updated_at
				}, function(data) {
					//Mensagem de retorno - console de navegador
					console.log("OK");
				});
					  
			});
}
//funcao para parar/pausar o serviço
function stopService(acao) {
	location.href = "ServDados?acao=" + acao;
}
//inserindo as celulas da tabela nos campos ja definido no html
function myFunction(id, name,field1,created_at,updated_at) {
    var table = document.getElementById("myTable");
    var row = table.insertRow(0);
    
    console.log(row);
    
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    
    cell1.innerHTML = id;
    cell2.innerHTML = name;
    cell3.innerHTML = field1;
    cell4.innerHTML = created_at;
    cell5.innerHTML = updated_at;
}
