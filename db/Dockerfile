FROM mongo:8

RUN groupadd --system --gid 1001 appuser \
    && useradd --system --uid 1001 --gid appuser appuser

COPY --chown=root:root --chmod=0444 mongodb-init.js /docker-entrypoint-initdb.d/mongodb-init.js

EXPOSE 27017