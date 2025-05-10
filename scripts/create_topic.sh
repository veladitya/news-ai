#!/bin/bash

echo "Waiting for Kafka to be ready..."
sleep 60  # Wait for Kafka to be fully initialized

echo "Creating Kafka topic nyt.rss.articles..."
kafka-topics --create --bootstrap-server kafka1:19092 \
  --replication-factor 3 --partitions 3 \
  --topic nyt.rss.articles \
  --config cleanup.policy=compact || echo "Topic creation failed or already exists"
echo "Topic creation script executed."
