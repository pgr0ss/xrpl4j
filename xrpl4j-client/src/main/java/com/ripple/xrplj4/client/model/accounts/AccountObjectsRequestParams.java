package com.ripple.xrplj4.client.model.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.primitives.UnsignedInteger;
import com.ripple.xrpl4j.model.jackson.modules.LedgerIndexSerializer;
import com.ripple.xrpl4j.model.transactions.Address;
import com.ripple.xrplj4.client.model.ledger.LedgerObject;
import com.ripple.xrplj4.client.rippled.JsonRpcRequestParams;
import org.immutables.value.Value;

import java.util.Optional;

/**
 * Represents the request parameters for an account_objects rippled JSON RPC API call.
 */
@Value.Immutable
@JsonSerialize(as = ImmutableAccountObjectsRequestParams.class)
@JsonDeserialize(as = ImmutableAccountObjectsRequestParams.class)
public interface AccountObjectsRequestParams extends JsonRpcRequestParams {

  static ImmutableAccountObjectsRequestParams.Builder builder() {
    return ImmutableAccountObjectsRequestParams.builder();
  }

  static AccountObjectsRequestParams of(Address classicAddress) {
    return builder()
      .account(classicAddress)
      .build();
  }

  /**
   * The unique XRPL {@link Address} for the account.
   */
  Address account();

  /**
   * If included, filter results to include only this type of ledger object.
   * The valid types are:
   * {@code "check"}, {@code "deposit_preauth"}, {@code "escrow"}, {@code "offer"}, {@code "payment_channel"},
   * {@code "signer_list"}, {@code "ticket"}, and {@code "state"} (trust line).
   */
  Optional<String> type();

  /**
   * If true, the response only includes {@link LedgerObject}s that would block this account from being deleted.
   * The default is false.
   */
  @JsonProperty("deletion_blockers_only")
  @Value.Default
  default boolean deletionBlockersOnly() {
    return false;
  }

  /**
   * A 20-byte hex string for the ledger version to use.
   */
  @JsonProperty("ledger_hash")
  Optional<String> ledgerHash();

  /**
   * The ledger index of the ledger to use, or a shortcut {@link String} to choose a ledger automatically.
   */
  @JsonSerialize(using = LedgerIndexSerializer.class)
  @JsonProperty("ledger_index")
  @Value.Default
  default String ledgerIndex() {
    return "current";
  }

  /**
   * The maximum number of {@link LedgerObject}s to include in the resulting
   * {@link AccountObjectsResult#accountObjects()}. Must be within the inclusive range 10 to 400 on non-admin
   * connections. The default is 200.
   */
  Optional<UnsignedInteger> limit();

  /**
   * Value from a previous paginated response. Resume retrieving data where that response left off.
   */
  Optional<String> marker();

}
