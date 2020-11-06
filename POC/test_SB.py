from SB import *
import collections

def test_items_set_of_items_in_raw_data_are_created_properly(mocker):
    data = [{"a", "b"},
            {"b", "c", "e", "f"},
            {"a", "c"}
            ]
    support = 0.6
    confidence = 0.8
    mocker.patch("SB.SB.find_frequent_items")
    mocker.patch("SB.SB.find_confident_rule")
    mocker.patch("SB.SB.find_interest")
    sb_fixture = SB(data, support, confidence)

    sb_fixture.run()
    expected_result = set(["a", "b", "c", "e", "f"])
    assert expected_result == sb_fixture.all_items


def test_frequent_items_are_found_correctly(mocker):
    data = [{"a", "b"},
            {"b", "c", "e", "f"},
            {"a", "d"}
            ]
    support = 0.8
    confidence = 0.8
    mocker.patch("SB.SB.find_confident_rule")
    mocker.patch("SB.SB.find_interest")
    sb_fixture = SB(data, support, confidence)

    sb_fixture.run()
    expected_result = [ItemsOccurrence(set(["a"]), 2), ItemsOccurrence(set(["b"]), 2)]
    assert collections.Counter(expected_result)==collections.Counter(sb_fixture.frequent_items)


def test_rules_with_required_confidence_are_selected_correctly(mocker):
    data = [{"a", "b"},
            {"b", "c", "a", "f"},
            {"c", "d"}
            ]
    support = 0.8
    confidence = 0.5
    mocker.patch("SB.SB.find_interest")
    sb_fixture = SB(data, support, confidence)

    sb_fixture.run()
    expected_result = [AssociationRule(set(["a"]), set(["b"]), 1),AssociationRule(set(["b"]), set(["a"]), 1)]
    assert collections.Counter(expected_result) == collections.Counter(sb_fixture.selected_rules)


def test_interest_of_rules_are_found_correctly():
    data = [{"a", "b"},
            {"b", "c", "a", "f"},
            {"c", "d"}
            ]
    support = 0.8
    confidence = 0.5
    sb_fixture = SB(data, support, confidence)

    sb_fixture.run()
    expected_result = [AssociationRule(set(["a"]), set(["b"]), 1, round(float(1/3), 4)),AssociationRule(set(["b"]), set(["a"]), 1, round(float(1/3), 4))]
    
    assert collections.Counter(expected_result) == collections.Counter(sb_fixture.selected_rules)
