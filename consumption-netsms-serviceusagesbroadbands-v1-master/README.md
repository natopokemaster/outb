# consumption-netsms-serviceusagesbroadbands-v1

## Objetivo:
O microsserviço é responsável por consultar informações de franquia e consumo de banda larga do cliente Claro Residencial.

* Consulta Consolidada: Retorna o consumo consolidado (mês a mês) de banda larga do cliente residencial;
* Consulta Detalhada: Retorna o consumo detalhado (dia a dia), informações de notificações e penalizações de banda larga do cliente residencial.

## Consumidor:
* API APIGEE - residential-serviceusagesbroadbands-v1

## Provedores:
* Base Mediation (CFM)
* Base Novo Atlas (ATLP)
* Base NETSMS (ISP)

## Exemplos:

### Verbo:
* GET "consumption/v1/netsms/serviceusages/broadbands"

### Media Type:
* Request: Header X-QueryString
* Response: application/json

### Descrição:
Consultar informações de franquia e consumo de banda larga do cliente Claro Residencial.

### cURL
* Consulta Consolidada:
```
curl --location 'http://consumption-netsms-serviceusagebroadbands-v1.dev.lpa.k8s.corp.clarobr/consumption/v1/netsms/serviceusages/broadbands' \
--header 'X-QueryString: customerContractId=295300&operatorCode=013&addressableCode=000E5CDDDE92&startDate=2012-01-28&endDate=2013-01-30&detailed=false'
```
* Consulta Detalhada:
```
curl --location 'http://consumption-netsms-serviceusagebroadbands-v1.dev.lpa.k8s.corp.clarobr/consumption/v1/netsms/serviceusages/broadbands' \
--header 'X-QueryString: customerContractId=295300&operatorCode=013&addressableCode=000E5CDDDE92&startDate=2012-01-28&endDate=2013-01-30&detailed=true'
```

### Response
* Consulta Consolidada:
```
{
    "data": {
        "serviceUsage": {
            "dataAllowance": {
                "quota": "60"
            },
            "creditPools": [
                {
                    "totalUsed": "72.00",
                    "totalContracted": "0",
                    "totalAvailable": "0",
                    "totalUsagePercentage": "120.00",
                    "month": "2012-02-16T00:00:00"
                },
                {
                    "totalUsed": "72.00",
                    "totalContracted": "0",
                    "totalAvailable": "0",
                    "totalUsagePercentage": "120.00",
                    "month": "2012-11-29T00:00:00"
                }
            ]
        }
    }
}
```

* Consulta Detalhada:
```
{
    "data": {
        "serviceUsage": {
            "dataAllowance": {
                "quota": "60"
            },
            "creditPools": [
                {
                    "totalUsed": "30",
                    "totalContracted": "0",
                    "totalAvailable": "30",
                    "totalUsagePercentage": "50",
                    "date": "2012-02-16T00:00:00",
                    "notification": ""
                },
                {
                    "totalUsed": "30",
                    "totalContracted": "0",
                    "totalAvailable": "30",
                    "totalUsagePercentage": "50",
                    "date": "2012-11-29T00:00:00",
                    "notification": ""
                }
            ]
        }
    }
}
```
