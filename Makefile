SERVER = harbor.prod.cpq.k8s.corp.clarobr
REPO = /event-bus/flows/connector/
NAME = rest-outbound
TAG = 1.0
IMAGE = $(SERVER)$(REPO)$(NAME):$(TAG)

all: build vuln

build:
	docker build --add-host nexus.prod.cpq.k8s.corp.clarobr:10.88.10.30 --build-arg "ALPINE_VERSION=$(TAG)" -t "$(IMAGE)" .

push:
	docker push "$(IMAGE)"

vuln:
	trivy image --scanners vuln --format json "$(IMAGE)" > vuln.json