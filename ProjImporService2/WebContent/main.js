function getService() {
	setInterval(function() {
		lerDados();
	}, 1000); // Intervalo de tempo que o serviço será chamado
}

function lerDados() {
	$.get("https://api.thingspeak.com/channels/318126/fields/1.json?results=2",
			function(data, status) {
				//Enviar dados para o Servlet
				$.post("ServDados", {
					id : data.channel.id,
					name : data.channel.name,
					description : data.channel.description,
					latitude : data.channel.latitude,
					longitude : data.channel.longitude,
					field1 : data.channel.field1,
					field2 : data.channel.field2,
					created_at : data.channel.created_at,
					updated_at : data.channel.updated_at,
					last_entry_id : data.channel.last_entry_id
				}, function(data) {
					//Mensagem de retorno - console de navegador
					consolo.log("OK");
				});
			});
}

function stopService(acao) {
	alert('entrei aqui: '+ acao);
	location.href = "ServDados?acao=" + acao;
}